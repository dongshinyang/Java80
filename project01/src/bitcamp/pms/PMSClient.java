package bitcamp.pms;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class PMSClient {
  Socket socket;
  Scanner in;
  PrintStream out;
  
  public PMSClient(String server, int port) throws Exception {
    socket = new Socket(server, port);
    in = new Scanner(new BufferedInputStream(socket.getInputStream()));
    out = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
  }
  
  public void close() {
    try {in.close();} catch (Exception e) {}
    try {out.close();} catch (Exception e) {}
    try {socket.close();} catch (Exception e) {}
  }
  
  public void execute() {
    Scanner keyScan = new Scanner(System.in);
    String command = null;

    do {
      command = sendCommand(keyScan);
      receiveMessage();
    } while (!command.equals("quit"));
    
    keyScan.close();
  }
  
  private String sendCommand(Scanner keyScan) {
    System.out.print("명령? ");
    String command = keyScan.nextLine();
    out.println(command);
    return command;
  }
  
  private void receiveMessage() {
    String message = null;
    do {
      message = in.nextLine();
      System.out.println(message);
    } while (!message.equals(""));
  }
  
  public static void main(String[] args) {
    //1) 프로그램 아규먼트 검사
    if (args.length != 2) {
      System.out.println("사용법: PMSClient 서버주소 포트번호");
      return;
    }
    
    PMSClient client = null;
    try {
      client = new PMSClient(args[0], Integer.parseInt(args[1]));
      client.execute();
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      client.close();
    }
  }
}







