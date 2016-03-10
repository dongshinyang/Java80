/* 목표
- 프로젝트 관리시스템 환영 메시지 출력
  "PMS에 오신 걸 환영합니다."
*/
package bitcamp.pms;

import java.util.Scanner;

public class ProjectApp {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print("이름? ");
    String name = keyScan.nextLine();

    System.out.print("이메일? ");
    String email = keyScan.nextLine();

    System.out.print("암호? ");
    String password = keyScan.nextLine();

    System.out.print("전화? ");
    String tel = keyScan.nextLine();

    System.out.println("--------------------------------");
    System.out.printf("%s, %s, %s, %s\n", name, email, password, tel);
  }
}
