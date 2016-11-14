package ch02.ex06;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OneLiner {

  public static Stream<Character> characterStream(String s) {
    return IntStream.range(0, s.length()-1).map(s::charAt).
  }
}
