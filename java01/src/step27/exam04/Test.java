package step27.exam04;

public class Test {

  public static void main(String[] args) {
    Class<?> clazz = Member.class;
    Component anno = clazz.getAnnotation(Component.class);
    System.out.println(anno.value());
  }

}






