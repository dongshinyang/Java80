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
    Scanner in = null;
    PrintStream out = null;
    
    try {
      socket = serverSocket.accept();
      in = new Scanner(new BufferedInputStream(socket.getInputStream()));
      out = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
    
    } catch (Exception e) {
      System.out.println("클라이언트 통신 오류!");
      
    } finally {
      try {in.close();} catch (Exception e) {}
      try {out.close();} catch (Exception e) {}
      try {socket.close();} catch (Exception e) {}
    }
  }
  
  public void close() {
    
  }
  
  private int getServerPort() {
    //java -Dport=8989 -cp ./bin PMSServer
    String value = System.getProperty("port");
    if (value != null) {
      return Integer.parseInt(value);
    }
    return 9999;
  }

  public static void main(String[] args) {
    PMSServer server = null;
    try {
      server = new PMSServer();
      server.execute();
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      server.close();
    }
  }
  

}









