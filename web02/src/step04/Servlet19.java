/* 주제: 파일업로드 처리 */
package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step04/servlet19")
public class Servlet19 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.printf("요청 method => %s\n", request.getMethod());

    request.setCharacterEncoding("UTF-8");
    
    // 화이팅!
    // => name, email, tel 값을 화면에 출력하라!
    // => 사진 파일은 배치 폴더의 files/ 디렉토리에 둔다.
    // => 예)
    // ...\tmp0\wtpwebapps\web02\files
  }
}

/*
# 

 */

















