package bitcamp.pms.controller;

import java.util.Scanner;

import bitcamp.pms.annotation.Controller;
import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;
import bitcamp.pms.util.CommandUtil;

@Controller
public class MemberUpdateController {
  private MemberDao memberDao;

  public void setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @RequestMapping("member/update.do")
  public void update(Scanner keyScan) {
    try {
      System.out.print("변경할 회원 번호는? ");
      int no = Integer.parseInt(keyScan.nextLine());
  
      Member oldMember = memberDao.selectOne(no);
      Member member = new Member();
  
      System.out.printf("이름(%s)? ", oldMember.getName());
      member.setName(keyScan.nextLine());
  
      System.out.printf("이메일(%s)? ", oldMember.getEmail());
      member.setEmail(keyScan.nextLine());
  
      System.out.printf("암호(%s)? ", oldMember.getPassword());
      member.setPassword(keyScan.nextLine());
  
      System.out.printf("전화(%s)? ", oldMember.getTel());
      member.setTel(keyScan.nextLine());
  
      if (CommandUtil.confirm(keyScan, "변경하시겠습니까?")) {
        memberDao.update(no, member);
        System.out.println("변경하였습니다.");
      } else {
        System.out.println("변경을 취소하였습니다.");
      }
    } catch (IndexOutOfBoundsException e) {
      System.out.println("유효한 번호가 아닙니다.");
    } catch (Exception e) {
      System.out.println("데이터 처리에 실패했습니다.");
    }
  }
}
