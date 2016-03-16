// 주제: 예외 객체의 다형성
package step19;

public class Test4 {
  public static void main(String[] args) {
    Calculator1 calc = new Calculator1();
    calc.plus(10);

    try {
      calc.divide(0);
      System.out.println("----------------");
      System.out.println(calc.result);
      System.out.println("----------------");
    //} catch (ArithmeticException e) { // 본인
    //} catch (RuntimeException e) {  // 부모
    //} catch (Exception e) { // 조부모
    } catch (Throwable e) { // 증조부모
    //} catch (Object e) { // 문법 오류!
                        // 다형적 변수를 사용하더라도
                        // Throwable까지만 사용할 수 있다.
                        // => catch()의 파라미터는 오직
                        //    Throwable 타입만 허용된다.
      System.out.println("나누기 오류 발생!");
      System.out.println(e.getMessage()); // 간단한 오류 정보
      System.out.println("----------------------");
      e.printStackTrace(); // 완전한 오류 정보
    }
  }






}
