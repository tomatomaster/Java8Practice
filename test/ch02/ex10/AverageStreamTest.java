package ch02.ex10;

import static org.hamcrest.CoreMatchers.is;

import java.util.stream.Stream;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

public class AverageStreamTest {

  @Test
  public void testAverage() {
    Stream<Double> stream = Stream.of(2.5, 6.5, 3.0);
    double actual = AverageStream.average(stream);
    double expected = 4.0;
    MatcherAssert.assertThat(actual, is(expected));
  }
  
  @Test
  public void testAverae2() {
    Stream<Double> stream = Stream.of(2.0,2.0,2.0,2.0,2.0);
    double actual = AverageStream.average(stream);
    double expected = 2.0;
    MatcherAssert.assertThat(actual, is(expected));
  }

}
