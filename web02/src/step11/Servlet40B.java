package step11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step11/servlet40/page2")
public class Servlet40B extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    String age = request.getParameter("age");
    
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<body>");
    out.println("<h1>추가정보</h1>");
    out.println("<form action='page3' method='post'>");
    out.printf("<input type='hidden' name='name' value='%s'>\n", name);
    out.printf("<input type='hidden' name='age' value='%s'>\n", age);
    out.println("전화: <input type='text' name='tel'><br>\n");
    out.println("이메일: <input type='text' name='email'><br>");
    out.println("<button>다음</button>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }
  
  
}








