package bitcamp.pms;

import java.util.Scanner;
import java.util.ArrayList;

public class Test2 {
  public static void main(String[] args) throws Exception {
    String[] students = {
      //  "이대희", "이민우", "박현신", "김현지", "곽용호", "김동래"
     
      "송석원", 
      "꽝!",
      "최춘호",
      "꽝!",
      "박기석", 
      "이천배"
    };

    ArrayList<String> list = new ArrayList<>();
    for (String s : students) {
      list.add(s);
    }
    
    Scanner keyScan = new Scanner(System.in);
    while (list.size() > 0) {
      keyScan.nextLine();
      System.out.println(list.remove((int)(Math.random() * list.size())));
    }


  }
}
