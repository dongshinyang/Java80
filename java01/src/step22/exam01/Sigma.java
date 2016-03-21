// 주제: 1에서 10까지 더하기
package step22.exam01;

public class Sigma {
  public static void main(String[] args) {
    //1)반복문 사용
    int sum = 0;
    for (int i = 1; i <= 10; i++) {
      sum += i;
    }
    System.out.println(sum);
    System.out.println("--------------------");

    sum = computeSigma(10);
    System.out.println(sum);
  }

  static int computeSigma(int value) {
    // 메서드 호출 상황 출력
    System.out.printf("%s computeSignam(%d)\n", printIndent(value), value);

    if (value == 1) {
      return value;
    } else {
      return value + computeSigma(value - 1);
    }
  }

  static String printIndent(int value) {
    StringBuffer buf = new StringBuffer();
    for (int i = 0; i < (10 - value); i++)
      buf.append(" ");
    return buf.toString();
  }





}
