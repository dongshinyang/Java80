/* 목표
- 프로젝트 관리시스템 환영 메시지 출력
  "PMS에 오신 걸 환영합니다."
*/
package bitcamp.pms;

import java.util.Scanner;
import bitcamp.pms.domain.Member;

public class ProjectApp {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    Member member = new Member();

    System.out.print("이름? ");
    member.setName(keyScan.nextLine());

    System.out.print("이메일? ");
    member.setEmail(keyScan.nextLine());

    System.out.print("암호? ");
    member.setPassword(keyScan.nextLine());

    System.out.print("전화? ");
    member.setTel(keyScan.nextLine());

    System.out.println("--------------------------------");
    System.out.println(member);
  }
}
