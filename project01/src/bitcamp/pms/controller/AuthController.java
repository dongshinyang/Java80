package bitcamp.pms.controller;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bitcamp.pms.annotation.Controller;
import bitcamp.pms.dao.MemberDao;

@Controller
public class AuthController {
  Scanner keyScan;
  MemberDao memberDao;
  
  public void setScanner(Scanner keyScan) {
    this.keyScan = keyScan;
  }
  
  public void setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  public void service() {
    String input = null;
    while (true) {
      System.out.println("1) 로그인");
      System.out.println("2) 회원가입");
      System.out.println("9) 종료");
      System.out.print("선택? ");
      input = keyScan.nextLine();
      
      switch (input) {
      case "1":
        if (doLogin()) {
          return;
        }
        break;
      case "2":
        doSignUp();
        break;
      case "9":
        System.out.println("안녕히가세요");
        System.exit(0);
        break;
      default:
        System.out.println("올바르지 않은 번호입니다.");
      }
    }
  }
  
  private void doSignUp() {
    System.out.print("이름: ");
    String name = keyScan.nextLine();
    
    String email = null;
    while (true) {
      System.out.print("이메일: ");
      email = keyScan.nextLine();
      if (email.matches("[a-zA-Z][\\w\\.]*@([\\w]+\\.)?[\\w]+\\.[a-zA-Z]{2,}"))
        break;
      System.out.println("이메일 형식에 맞지 않습니다. 예) aaa.aaa@bbb.com");
    }
    
    String password = null;
    String regex = null;
    Pattern pattern = null;
    Matcher matcher = null;
    
    while (true) {
      System.out.print("암호: ");
      password = keyScan.nextLine();
      
      if (password.length() < 4 || password.length() > 10) {
        System.out.println("암호는 4 ~ 10자 까지만 가능합니다.");
        continue;
      }
      
      regex = String.format(
          "(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@?])[0-9a-zA-Z!@?]{%d}", 
          password.length());

      pattern = Pattern.compile(regex);
      matcher = pattern.matcher(password); 
      
      if (matcher.find()) {
        break;
      }
      
      System.out.println(
          "최소 알파벳1개, 숫자1개, 특수문자(?,!,@)1개를 반드시 포함해야 합니다.");
    }
    
    String tel = null;
    while (true) {
      System.out.print("전화: ");
      tel = keyScan.nextLine();
      if (tel.matches("(\\d{2,4}-)?\\d{3,4}-\\d{4}"))
        break;
      System.out.println("전화 형식에 맞지 않습니다. 예) 02-123-1234");
    }
    
  }

  private boolean doLogin() {
    System.out.print("이메일: ");
    String email = keyScan.nextLine();
    
    System.out.print("암호: ");
    String password = keyScan.nextLine();
    
    if (memberDao.isMember(email, password)) {
      return true;
    } else {
      System.out.println("이메일 또는 암호가 맞지 않습니다.");
      return false;
    }
  }
}
