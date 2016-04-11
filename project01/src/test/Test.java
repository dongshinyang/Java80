package test;

import java.util.Scanner;

public class Test {

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    
    String regex = "[a-zA-Z!@?]*[0-9]*[a-zA-Z!@?]*"; //[a-zA-Z]+(.&&[^a-zA-Z])*"; 
    
    String input = null;
    
    while (true) {
      System.out.print("입력: ");
      input = keyScan.nextLine();
      if (input.equals("quit"))
        break;
      System.out.println(input.matches(regex));
    }
    
    keyScan.close();
  }

}










