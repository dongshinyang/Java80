package algorithm.ex01;

public class LinkedList {
  Bucket start;
  Bucket end;
  int count;

  public LinkedList() {
    start = new Bucket();
    end = start;
  }

  public int size() {
      return this.count;
  }

  public void add(Object value) {
    end.value = value;
    end.next = new Bucket();
    end = end.next;
    count++;
  }

  public void add(int index, Object value) {
    //1) index 유효범위 검사
    if (index < 0 || index > this.count) {
      return;
    }

    //2) index가 0일 때
    if (index == 0) {
      Bucket newBucket = new Bucket(value, start);
      start = newBucket;
      count++;
      return;
    }

    //3) index가 빈 버킷을 가리킬 때
    if (index == this.count) {
      this.add(value);
      return;
    }

    //4) 그 밖에
    // => 인덱스가 가리키는 항목의 직전 항목을 찾아서 새 버킷을 연결한다.
    Bucket cursor = start;
    for (int i = 0; i < (index - 1); i++) {
      cursor = cursor.next;
    }

    cursor.next = new Bucket(value, cursor.next);
    count++;
  }

  public Object get(int index) {
    return null;
  }

  public Object remove(int index) {
    return null;
  }

  public Object set(int index, Object value) {
    return null;
  }
}
