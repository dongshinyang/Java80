package designpattern.chainofresponsibility;

public class PlusOperator extends AbstractOperator {
  @Override
  public int calculate(String op, int a, int b) throws Exception {
    if (op.equals("+")) {
      return a + b;
    }
    return super.calculate(op, a, b); 
  }
  
}
