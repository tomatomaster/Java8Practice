package ch02.ex13;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AtomicIncrement {

  public static void main(String[] args) {
    String[] words = {"ni","san","san","san","1","yoon"};
    method(words);
  }
  
  public static Map<Integer, Long> method(String[] words) {
    Stream<String> stream = Stream.of(words);
    Map<Integer, Long> map = stream.filter(s -> {
      if(s.length() < 5)
        return true;
      return false;
    }).collect(Collectors.groupingBy(String::length, Collectors.counting()));
    return map;
  }
}
