// 주제: 상속
package step14;

public class Exam01 {
  public static void main(String[] args) {
    // 기존 클래스 사용 계산(연산자 우선순위를 고려하지 않는다)
    // => 2 * 3 + 7 % 3 = ?
    Calculator calc = new Calculator();
    calc.plus(2);
    calc.multiple(3);
    calc.plus(7);
    // 나머지를 구하는 메서드는 없기 때문에
    // 기존 클래스로 계산할 수 없다.
    System.out.println(calc.result);
    System.out.println("------------------------");

    // 기존 클래스의 기능을 확장한 서브 클래스를 사용한다.
    Calculator2 calc2 = new Calculator2();
    calc2.plus(2);
    calc2.multiple(3);
    calc2.plus(7);
    calc2.remainder(3);
    System.out.println(calc2.result);

  }
}
