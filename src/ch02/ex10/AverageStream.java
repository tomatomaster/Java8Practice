package ch02.ex10;

import java.util.stream.Stream;

/**
 * countを呼ぶとストリームが閉じてしまい、ストリーム操作ができなくなるため。 
 *
 */
public class AverageStream {

  public static void main(String[] args) {
    Stream<Double> stream = Stream.of(2.2,4.4,3.1);
    double result = average(stream);
    System.out.println(result);
  }
  
  /**
   * ??? できなかった
   * @param stream
   * @return
   */
  public static double average(Stream<Double> stream) {
    return stream.reduce(0.0, (x, y) -> x + y).doubleValue();
  }
}
