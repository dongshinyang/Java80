package bitcamp.pms.controller;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import bitcamp.pms.domain.Member;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileReader;

import java.io.BufferedReader;

public class BoardController implements MenuController {
  private static final String filename = "board.data";
  private Scanner keyScan;
  private ArrayList<Member> members;

  public BoardController() {
    members = new ArrayList<>();
  }

  @Override
  public String toString() {
    return "board";
  }

  public void load() throws Exception {
    FileReader in0 = new FileReader(filename);
    BufferedReader in = new BufferedReader(in0);

    String line;
    String[] values;
    Member member;
    while ((line = in.readLine()) != null) {
      values = line.split(",");
      member = new Member(values[0], values[1], values[2], values[3]);
      members.add(member);
    }

    in.close();
    in0.close();
  }

  public void save() throws Exception {
    FileWriter out0 = new FileWriter(filename);
    BufferedWriter out1 = new BufferedWriter(out0);
    PrintWriter out = new PrintWriter(out1);

    for (Member member : members) {
      out.println(member);
    }

    out.close();
    out1.close();
    out0.close();
  }

  @Override
  public void init() {
    try {
      this.load();
    } catch (Exception e) {
      throw new RuntimeException("게시판 데이터 로딩 실패!", e);
    }
  }

  @Override
  public void service(Map<String,Object> paramMap) {
    keyScan = (Scanner)paramMap.get("stdin");

    String input = null;
    do {
      input = prompt();
      try {
        switch (input) {
          case "about": doAbout(); break;
          case "main": break;
          default:
            System.out.println("지원하지 않는 명령어입니다.");
        }
      } catch (IndexOutOfBoundsException e) {
        System.out.println("유효하지 않은 인덱스입니다.");
      }
    } while (!input.equals("main"));
  }

  @Override
  public void destroy() {
    try {
      this.save();
    } catch (Exception e) {}
  }

  private String prompt() {
    System.out.print("게시판관리> ");
    return keyScan.nextLine().toLowerCase();
  }

  private void doAbout() {
    System.out.println("게시판 준비 중입니다. ");
  }
  
}
