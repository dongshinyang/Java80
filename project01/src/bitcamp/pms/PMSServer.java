package bitcamp.pms;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class PMSServer {
  ServerSocket serverSocket;
  
  public PMSServer() throws Exception {
    serverSocket = new ServerSocket(this.getServerPort());
  }
  
  public void execute() {
    Socket socket = null;
    try {
      while (true) {
        socket = serverSocket.accept();
        serviceClient(socket);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void close() {
    try {serverSocket.close();} catch (Exception e) {}
  }
  
  private int getServerPort() {
    //java -Dport=8989 -cp ./bin PMSServer
    String value = System.getProperty("port");
    if (value != null) {
      return Integer.parseInt(value);
    }
    return 9999;
  }
  
  private void serviceClient(Socket socket) {
    Scanner in = null;
    PrintStream out = null;
    
    try {
      in = new Scanner(new BufferedInputStream(socket.getInputStream()));
      out = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
      
      String command = null;
      while (true) {
        command = in.nextLine();
        if (command.equals("quit")) {
          break;
        }
        out.println("haha");
        out.println("너가 보낸 명령어: " + command);
        out.println();
        out.flush();
      }
    
      out.println("Good bye!");
      out.println();
      out.flush();
      
    } catch (Exception e) {
      System.out.println("클라이언트 통신 오류!");
      
    } finally {
      try {in.close();} catch (Exception e) {}
      try {out.close();} catch (Exception e) {}
      try {socket.close();} catch (Exception e) {}
    }
  }

  public static void main(String[] args) {
    PMSServer server = null;
    try {
      server = new PMSServer();
      System.out.println("PMSServer 실행 중...");
      
      server.execute();
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      server.close();
    }
  }
  

}









