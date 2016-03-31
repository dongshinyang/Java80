package bitcamp.pms.controller;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import bitcamp.pms.annotation.Component;
import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;

@Component("member/update.do")
public class MemberUpdateController implements MenuController {
  MemberDao memberDao = new MemberDao();
  
  private Scanner keyScan;

  @Override
  public void init() {}

  @Override
  public void service(Map<String,Object> paramMap) {
    keyScan = (Scanner)paramMap.get("stdin");

    try {
      List<Member> members = memberDao.load();
      
      System.out.print("변경할 회원 번호는? ");
      int no = Integer.parseInt(keyScan.nextLine());
  
      Member oldMember = members.get(no);
      Member member = new Member();
  
      System.out.printf("이름(%s)? ", oldMember.getName());
      member.setName(keyScan.nextLine());
  
      System.out.printf("이메일(%s)? ", oldMember.getEmail());
      member.setEmail(keyScan.nextLine());
  
      System.out.printf("암호(%s)? ", oldMember.getPassword());
      member.setPassword(keyScan.nextLine());
  
      System.out.printf("전화(%s)? ", oldMember.getTel());
      member.setTel(keyScan.nextLine());
  
      if (confirm("변경하시겠습니까?", true)) {
        members.set(no, member);
        System.out.println("변경하였습니다.");
      } else {
        System.out.println("변경을 취소하였습니다.");
      }
      
      memberDao.save(members);

    } catch (IndexOutOfBoundsException e) {
      System.out.println("유효한 번호가 아닙니다.");
    } catch (Exception e) {
      System.out.println("데이터 처리에 실패했습니다.");
    }
  }

  @Override
  public void destroy() {}

  private boolean confirm(String message, boolean strictMode) {
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
