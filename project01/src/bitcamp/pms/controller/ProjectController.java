package bitcamp.pms.controller;

import java.util.Scanner;
import java.sql.Date;
import bitcamp.pms.domain.Project;

public class ProjectController {
  private Scanner keyScan;

  public void setScanner(Scanner keyScan) {
    this.keyScan = keyScan;
  }

  public void service() {
    String input = null;
    while (true) {
      input = prompt();
      if (input.equals("main")) {
        break;
      } else if (input.equals("add")) {
        doAdd();
      } else if (input.equals("list")) {
        doList();
      } else if (input.equals("update")) {
        doUpdate();
      } else if (input.equals("delete")) {
        doDelete();
      } else {
        System.out.println("지원하지 않는 명령어입니다.");
      }

    }
  }

  private String prompt() {
    System.out.print("프로젝트관리> ");
    return keyScan.nextLine();
  }

  private void doAdd() {
    Project project = new Project();

    System.out.print("프로젝트명? ");
    project.setTitle(keyScan.nextLine());
    System.out.print("시작일? ");
    project.setStartDate(Date.valueOf(keyScan.nextLine()));
    System.out.print("종료일? ");
    project.setEndDate(Date.valueOf(keyScan.nextLine()));
    System.out.print("설명? ");
    project.setDescription(keyScan.nextLine());

    System.out.print("저장하시겠습니까?(y/n) ");
    String input = keyScan.nextLine().toLowerCase();
    if (input.equals("y")) {
      System.out.print("저장하였습니다.");
      System.out.println(project);
    } else {
      System.out.print("저장을 취소하였습니다.");
    }
  }

  private void doList() {
    System.out.println("list 입니다.");
  }

  private void doUpdate() {
    System.out.println("update 입니다.");
  }

  private void doDelete() {
    System.out.println("delete 입니다.");
  }








}
