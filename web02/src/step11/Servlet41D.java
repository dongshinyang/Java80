package step11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/step11/servlet41/page4")
public class Servlet41D extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    HttpSession session = request.getSession();
    String name = (String)session.getAttribute("name");
    String age = (String)session.getAttribute("age");
    String tel = (String)session.getAttribute("tel");
    String email = (String)session.getAttribute("email");
    
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<body>");
    out.println("<h1>입력 결과</h1>");
    out.printf("[%s,%s,%s,%s] 정보를 저장하였습니다.\n", name, age, tel, email);
    out.println("</body>");
    out.println("</html>");
  }
  
  
}








