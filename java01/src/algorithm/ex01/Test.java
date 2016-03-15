package algorithm.ex01;

public class Test {
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add("홍길동"); // index = 0
    list.add("임꺽정"); // index = 1
    list.add("유관순"); // index = 2
    list.add("안창호"); // index = 3
    list.add("김원봉"); // index = 4
    list.add("김구"); // index = 5

    list.add(-10, "안중근");

    Bucket cursor = list.start;
    for (int i = 0; i < list.size(); i++) {
      System.out.println(cursor.value);
      cursor = cursor.next;
    }

  }
}
