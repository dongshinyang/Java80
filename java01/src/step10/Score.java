package step10;

// 패키지 직속 클래스는 static을 붙이지 않는다.
class Score {
  String name;
  // 점수를 저장할 변수의 접근 레벨을 조정한다.
  // => 외부 접근에 대해 격리 레벨을 높힌다.
  private int kor;
  private int eng;
  private int math;
  private int sum;
  private float aver;

  Score(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
  }

  void summary() {
    this.sum = this.kor + this.eng + this.math;
  }

  void average() {
    this.aver = this.sum / 3f;
  }

}
