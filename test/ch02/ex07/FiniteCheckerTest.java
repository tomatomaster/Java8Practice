package ch02.ex07;

import static org.junit.Assert.*;

import java.util.stream.Stream;

import org.apache.commons.math3.util.DoubleArray;
import org.junit.After;
import org.junit.Test;

public class FiniteCheckerTest {

  Stream<Double> infiniteStream = Stream.generate(Math::random);
  Stream<Double> finiteStream = Stream.of(2.2,22.0);
  
  @Test
  public void testIsFinite() {
    assertEquals(true, FiniteChecker.isFinite(finiteStream));
  }
  
  @Test
  public void testIsNotFinite() {
    assertEquals(false, FiniteChecker.isFinite(infiniteStream));
  }
  
  @Test(expected = IllegalStateException.class)
  public void hasClosed() {
    FiniteChecker.isFinite(infiniteStream);
    infiniteStream.forEach(System.out::println);
  }

}
