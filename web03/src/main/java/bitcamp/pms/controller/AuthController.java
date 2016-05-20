package bitcamp.pms.controller;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.vo.Member;

@Controller
@RequestMapping("/auth")
@SessionAttributes("loginUser")
public class AuthController {
  @Autowired
  MemberDao memberDao;
  
  @RequestMapping(value="/login", method=RequestMethod.GET)
  public String form(@CookieValue(required=false) String email, Model model) {
    if (email != null) {
      model.addAttribute("email", email);
      model.addAttribute("checked", "checked");
    }
    return "auth/form";
  }
  
  @RequestMapping(value="/login", method=RequestMethod.POST)
  public String login(
      String email,
      String password,
      String emailsave,
      HttpServletResponse response,
      Model model) {
    if (emailsave != null) {
      Cookie cookie = new Cookie("email", email);
      cookie.setMaxAge(3600);
      response.addCookie(cookie);
    } else {
      Cookie cookie = new Cookie("email", "");
      cookie.setMaxAge(0);
      response.addCookie(cookie);
    }
    
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("email", email);
    paramMap.put("password", password);
    
    if (memberDao.isMember(paramMap) > 0) {
      Member member = memberDao.selectOne(paramMap);
      model.addAttribute("loginUser", member);
      return "redirect:../board/list.do";

    } else { // 로그인 실패!
      return "redirect:login.do";
    }
  }
  
  @RequestMapping("/logout")
  public String logout(HttpSession session, SessionStatus status) {
    status.setComplete(); // @SessionAttributes 로 관리하는 값 제거
    session.invalidate(); // HttpSession 객체 무효화시킨다.
                          // => invalidate()는 스프링에서 @SessionAttributes로
                          //    관리하는 값을 제거하지 못한다.
    return "redirect:login.do";
  }
}
















