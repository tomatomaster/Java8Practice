package ch02.ex02;

import java.util.Arrays;
import java.util.List;



public class FilterCheck {

  static String[] dataList = {"check", "toughness", "illegal", "cache", "satellite", "BigBen"};
  static List<String> testData;

  public static void main(String[] args) {
    testData = Arrays.asList(dataList);
    check();
  }

  static void check() {
    testData.stream().filter(w -> {
      System.out.println("test");
      if (w.length() > 3) {
        return true;
      }
      return false;
    }
    ).findFirst();  }
}
