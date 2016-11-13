package ch02.ex04;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOf {
  static int[] values = {1, 4, 9, 16};

  public static void main(String[] args) {
    Stream.of(values); //int配列のStreamになる
    IntStream intStream = IntStream.of(values);
  }
}
