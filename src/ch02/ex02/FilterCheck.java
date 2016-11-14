package ch02.ex02;

import java.util.Arrays;
import java.util.List;



public class FilterCheck {

  static String[] dataList = {"check", "toughness", "illegal", "cache", "satellite", "BigBen"};
  static List<String> testData;

  public static void main(String[] args) {
    forTest();
  }

  public static void forTest() {
    testData = Arrays.asList(dataList);
    testData.stream().limit(5).filter(w -> {
      System.out.println("==Log==");
      if(w.length() > 2) {
        return true;
      }
        return false;
    }).forEach(System.out::println);
  }
  
  
}
