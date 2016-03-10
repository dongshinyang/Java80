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
    String input = keyScan.nextLine();
    System.out.printf("이름은 %s입니다.\n", input);
  }
}
