package ch02.ex10;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * countを呼ぶとストリームが閉じてしまい、ストリーム操作ができなくなるため。
 *
 */
public class AverageStream {

  public static void main(String[] args) {
    Stream<Double> stream = Stream.of(2.5, 6.5, 3.0);
    double result = average(stream);
    System.out.println(result);
  }

  public static double average(Stream<Double> stream) {
    AtomicInteger atom = new AtomicInteger();
    return stream.reduce(0.0 , (sum, target) -> {
      atom.incrementAndGet();
      return (sum + target);
    }).doubleValue()/atom.get();
  }
}
