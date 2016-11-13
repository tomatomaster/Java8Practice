package ch02.ex05;


import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class LinearCongruentialGenerator {

  public static void main(String[] args) {
    Stream<Long> random = getRandomStream(25214903917L, 11L, (long)Math.pow(2, 48));
    random.limit(10).forEach(System.out::println);
  }
  
  public static Stream<Long> getRandomStream(long a, long c, long m) {
    return Stream.iterate(5L, n -> {
      return (a*n + c)%m;
    });
  }
}
