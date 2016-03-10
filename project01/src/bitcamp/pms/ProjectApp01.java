/* 목표
- 명령어에 따라 회원 정보를 다룰 수 있도록 변경하라.
명령> add
이름? 홍길동
이메일? hong@test.com
암호? 1111
전화? 111-1111
저장하시겠습니까?(y/n) y
저장하였습니다.
저장하시겠습니까?(y/n) N
저장을 취소하였습니다.
명령> list
0, 홍길동, hong@test.com, 1111, 1111-2222
1, 홍길동, hong@test.com, 1111, 1111-2222
2, 홍길동, hong@test.com, 1111, 1111-2222
3, 홍길동, hong@test.com, 1111, 1111-2222
명령> delete
삭제할 회원의 번호는? 2
정말로 삭제하시겠습니까?(y/n) y
삭제하였습니다.
정말로 삭제하시겠습니까?(y/n) n
삭제를 취소하였습니다.
명령> list
0, 홍길동, hong@test.com, 1111, 1111-2222
1, 홍길동, hong@test.com, 1111, 1111-2222
2,
3, 홍길동, hong@test.com, 1111, 1111-2222
명령> quit
안녕히 가세요!
명령> xxx
올바르지 않은 명령어입니다.
명령>
- 사용 문법:
  => 반복문과 조건문의 활용
*/
package bitcamp.pms;

import java.util.Scanner;
import bitcamp.pms.domain.Member;

public class ProjectApp {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    String input;
    while (true) {
      System.out.print("명령> ");
      input = keyScan.nextLine();
      System.out.println(input);
    }

    /*
    Member[] members = new Member[1000];
    int count = 0;

    Member member = null;
    String input = null;

    while (count < 1000) {
      member = new Member();

      System.out.print("이름? ");
      member.setName(keyScan.nextLine());

      System.out.print("이메일? ");
      member.setEmail(keyScan.nextLine());

      System.out.print("암호? ");
      member.setPassword(keyScan.nextLine());

      System.out.print("전화? ");
      member.setTel(keyScan.nextLine());


      if (confirm("저장하시겠습니까?", true)) {
        members[count++] = member;
        System.out.println("저장하였습니다.");
      } else {
        System.out.println("저장을 취소하였습니다.");
      }

      if (!confirm("계속하시겠습니까?", false)) {
        break;
      }

    }

    System.out.println("--------------------------------");

    for (int i = 0; i < count; i++) {
      System.out.println(members[i]);
    }
    */
  }

  static boolean confirm(String message, boolean strictMode) {
    Scanner keyScan = new Scanner(System.in);
    String input = null;
    do {
      System.out.printf("%s(y/n) ", message);
      input = keyScan.nextLine().toLowerCase();

      if (input.equals("y")) {
        return true;
      } else if (input.equals("n")) {
        return false;
      } else {
        if (!strictMode) {
          return false;
        }
        System.out.println("잘못된 명령어입니다.");
      }
    } while(true);
  }
}
