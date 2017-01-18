package ch06.ex07;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class FindMaxValue {

  public static void main(String[] args) {
    ConcurrentHashMap<String, Integer> randomMap = new ConcurrentHashMap<String, Integer>();
    new Random().ints(10000).forEach(value->randomMap.put(String.valueOf(value) , value));
    Map.Entry<String, Integer> max = randomMap.reduceEntries(1, (e1,e2) -> e1.getValue() > e2.getValue() ? e1 : e2);
    System.out.println(max);
  }
}
