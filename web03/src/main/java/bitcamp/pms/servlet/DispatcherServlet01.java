package bitcamp.pms.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;

public class DispatcherServlet01 extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    response.setContentType("text/html;charset=UTF-8");

    // 1) 페이지 컨트롤러의 서블릿 경로를 알아낸다.
    String pageControllerPath = request.getServletPath().replace(".do", "");
    
    // 2) 페이지 컨트롤러를 찾는다.
    Object pageController = findPageController(pageControllerPath);
    
    try {
      // 3) 페이지 컨트롤러에서 해당 URL을 처리하는 메서드를 찾는다.
      Method method = findRequestHandler(pageController, pageControllerPath);
      String viewUrl = (String)method.invoke(pageController, request, response);
    
      // 4) 뷰 컴포넌트를 실행한다.
      if (viewUrl.startsWith("redirect:")) {
        response.sendRedirect(viewUrl.substring(9));
      } else {
        RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
        rd.include(request, response);
      }
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }

  private Method findRequestHandler(Object pageController, String pageControllerPath) {
    // 1) 페이지 컨트롤러의 클래스 정보를 알아낸다.
    Class<?> clazz = pageController.getClass();
    
    // 2) 클래스에 붙은 @RequestMapping의 값을 알아내기
    RequestMapping anno = clazz.getAnnotation(RequestMapping.class);
    String url = anno.value()[0];
    
    // 2) 클래스에 선언된 메서드 목록을 알아낸다.
    Method[] methods = clazz.getMethods();
    
    // 3) @RequestMapping이 붙은 메서드를 알아낸다.
    for (Method m : methods) {
      anno = m.getAnnotation(RequestMapping.class);
      if (anno == null) 
        continue;
      
      // 페이지 컨트롤러에 선언한 경로와 메서드에 선언한 경로를 합쳐서
      // pageControllerPath와 같은 지 비교한다.
      if ((url + anno.value()[0]).equals(pageControllerPath))
        return m;
    }
    
    return null;
  }

  private Object findPageController(String pageControllerPath) {
    ServletContext servletContext = this.getServletContext();
    ApplicationContext applicationContext = 
        (ApplicationContext)servletContext.getAttribute("iocContainer");
    
    // 1) @RequestMapping이 붙은 객체를 찾는다.
    Map<String,Object> beanMap = 
        applicationContext.getBeansWithAnnotation(RequestMapping.class);
    
    // 2) 애노테이션의 값이 pageControllerPath와 앞부분이 일치하는 지 검사한다.
    String value = null;
    for (Object obj : beanMap.values()) {
      value = obj.getClass().getAnnotation(RequestMapping.class).value()[0]; 
      if (pageControllerPath.startsWith(value))
        return obj;
    }
    return null;
  }
}










