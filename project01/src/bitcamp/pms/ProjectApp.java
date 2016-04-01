/* 목표
- 명령어를 처리하는 메서드(RequestHandler)의 파라미터 선언을 자유롭게 하도록 
  변경한다. 
- ProjectApp에서는 메서드를 호출하기 전에 파라미터를 분서하여 그에 맞는
  값을 준비해야 한다.  

- 작업절차
[ProjectApp에 메서드의 파라미터를 분석하는 기능 추가]

 
*/
package bitcamp.pms;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Scanner;

import bitcamp.pms.context.ApplicationContext;
import bitcamp.pms.context.request.RequestHandler;
import bitcamp.pms.context.request.RequestHandlerMapping;

public class ProjectApp {
  static ApplicationContext appContext;
  static RequestHandlerMapping requestHandlerMapping;
  static Scanner keyScan = new Scanner(System.in);

  public static void main(String[] args) {
    appContext = new ApplicationContext("bitcamp.pms");
    requestHandlerMapping = new RequestHandlerMapping(appContext);

    String input;
    do {
      input = prompt();
      processCommand(input);
    } while (!input.equals("quit"));

    keyScan.close(); // 항상 다 쓴 자원은 해제해야 한다.
  }

  static void processCommand(String input) {
    String[] cmds = input.split(" ");

    if (cmds[0].equals("quit")) {
      doQuit();
    } else if (cmds[0].equals("about")) {
      doAbout();
    } else {
      
      RequestHandler requestHandler = 
          (RequestHandler) requestHandlerMapping.getRequestHandler(cmds[0]);
      if (requestHandler != null) {
        // 작업에 필요한 재료를 준비
        HashMap<String,Object> paramMap = new HashMap<>();
        paramMap.put("stdin", keyScan);
        
        Method method = requestHandler.getMethod();
        Object obj = requestHandler.getObj();
        try {
          //1) 메서드의 파라미터 정보를 알아낸다.
          Parameter[] params = method.getParameters();
          
          
          method.invoke(obj, paramMap);
        } catch (Exception e) {
          System.out.println("명령 처리 중에 오류가 발생했습니다!");
        }
      } else {
        doError();
      }
    }
  }

  static String prompt() {
    System.out.print("명령> ");
    return keyScan.nextLine().toLowerCase();
  }

  static void doQuit() {
    System.out.println("안녕히 가세요!");
  }

  static void doError() {
    System.out.println("올바르지 않은 명령어입니다.");
  }

  static void doAbout() {
    System.out.println("비트캠프 80기 프로젝트 관리 시스템!");
  }

}
