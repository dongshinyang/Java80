/* 주제: GET 요청과 POST 요청 차이점 */
package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step04/servlet16")
public class Servlet16 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.printf("요청 method => %s\n", request.getMethod());
  }
}

/*
# GET 요청의 파라미터
=> GET 요청은 Request-URI에 파라미터 값을 붙여 보낸다.
=> HTTP 요청 프로토콜
GET /web02/step04/servlet16?name=aaa&email=bbb&tel=ccc HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,...
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36
Referer: http://localhost:8080/web02/step04/getpost2.html
Accept-Encoding: gzip, deflate, sdch
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4
=> 특징
  1) 대용량의 데이터를 보낼 수 없다. 
     => Request-Line(헤더 포함)의 크기는 보통 8KB로 제한되어 있다.
        물론 웹서버마다 제한하는 크기가 약간씩 다르기는 하지만, 
        무제한으로 허용하지 않는다는 것은 공통 사항이다.
        그리고 그 크기가 작다는 것도 공통 사항이다.
     => 게시판의 글을 GET 방식으로 보내는 것은 바람직하지 않다.
      

# POST 요청의 파라미터
=> POST 요청은 message-body에 파라미터 값을 붙여 보낸다.
=> HTTP 요청 프로토콜
POST /web02/step04/servlet16 HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Content-Length: 26
Cache-Control: max-age=0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,...
Origin: http://localhost:8080
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36
Content-Type: application/x-www-form-urlencoded
Referer: http://localhost:8080/web02/step04/getpost2.html
Accept-Encoding: gzip, deflate
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4
(CRLF)
name=aaa&email=bbb&tel=ccc
=> 특징
  1) 대용량 데이터를 보낼 수 있다.
     => message-body에 붙여 보내기 때문에 서버가 허용하는 한에는 
        무제한으로 데이터를 보낼 수 있다.
 */

















