package step23;

import java.util.Calendar;
import java.util.ArrayList;

public class HelloJp extends AbstractHello {
  ArrayList<String> list = new ArrayList<String>();

  public HelloJp() {
    list.add("こんにちは。");
    list.add("こんばんは");
  }
  public String sayHello() {
    Calendar cal = Calendar.getInstance();
    int hour = cal.get(Calendar.HOUR);
    if (hour < 18) {
      return list.get(0);
    } else {
      return list.get(1);
    }
  }
}
