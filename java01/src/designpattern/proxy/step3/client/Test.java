/* 주제: 클라이언트 개발자가 Calculator 객체를 쉽게 사용할 수 있도록 
 *       서버 개발자 쪽에서 계산기 대행자(proxy)를 만들어 제공한다.
 * => 이점
 *    클라이언트 개발자는 계산기 대행자를 사용하여 서버 계산기를 이용한다.
 *    대행자가 서버측 계산기와 같은 인터페이스를 구현하기 때문에
 *    클라이언트 개발자는 마치 로컬 객체인 것처럼 사용할 수 있다.
 * => 단점
 *    서버 개발자가 클라이언트 개발자를 위해 서비스 호출 대행자를 만들어 
 *    제공해야 한다.
 * 
 * => 용어 정리!
 * 1) 스켈레톤(skeleton) 
 *    서버 쪽에서 클라이언트 요청을 받아 실제 서비스 객체를 호출하는 역할.
 * 2) 스텁(stub)
 *    클라이언트 쪽에서 서버에게 요청을 중개해주는 역할.
 *    인터페이스는 서버쪽 비즈니스 객체와 같다.     
 * 3) ORB(Object Request Broker)
 *    클라이언트 또는 서버쪽에서 요청 중개를 담당하는 스켈레톤, 스텁 객체를 말한다.
 */

package designpattern.proxy.step3.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Test {

  public static void main(String[] args) throws Exception {
    // 계산기 객체 사용하기
    // 1) 소켓을 통해 계산 수행
    // 2) 메서드 호출
    System.out.printf("10 + 20 = %f\n", calculate("plus", 10, 20));
    System.out.printf("10 - 20 = %f\n", calculate("minus", 10, 20));
    System.out.printf("10 * 20 = %f\n", calculate("multiple", 10, 20));
    System.out.printf("10 / 20 = %f\n", calculate("divide", 10, 20));
  }
  
  public static double calculate(String method, double a, double b) throws Exception {
    Socket socket = new Socket("localhost", 9999);
    DataInputStream in = new DataInputStream(socket.getInputStream());
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
    
    out.writeUTF(method);
    out.writeDouble(a);
    out.writeDouble(b);
    
    double result = in.readDouble();
    
    try {in.close();} catch (Exception e) {}
    try {out.close();} catch (Exception e) {}
    try {socket.close();} catch (Exception e) {}
    
    return result;
  }

}






