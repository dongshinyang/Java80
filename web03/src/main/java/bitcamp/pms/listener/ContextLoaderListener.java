package bitcamp.pms.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextLoaderListener implements ServletContextListener {
  
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    // 스프링 IoC 컨테이너 준비
    // 1) 스프링 설정 파일의 절대 경로 알아내기
    ServletContext servletContext = sce.getServletContext();
    String configPath = servletContext.getInitParameter("contextConfigLocation");
    System.out.println(servletContext.getRealPath(configPath));
    
    //ApplicationContext applicationContext = 
    //    new ClassPathXmlApplicationContext();
    
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {}

}





