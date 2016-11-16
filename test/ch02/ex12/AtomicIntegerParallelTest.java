package ch02.ex12;

import static org.junit.Assert.*;

import org.junit.Test;

import ch02.ex12.AtomicIntegerParallel;

public class AtomicIntegerParallelTest {

  @Test
  public void testMethod() {
    String[] test1 = {"","",""};
    AtomicIntegerParallel.method(test1);
    int[] actual = AtomicIntegerParallel.getAtomcInteger();
    int[] expected = {3,0,0,0,0};
    assertArrayEquals(expected ,actual);
  }
  
  @Test
  public void test() {
    String[] test2 = {"1","1","1"};
    AtomicIntegerParallel.method(test2);
    int[] actual = AtomicIntegerParallel.getAtomcInteger();
    int[] expected = {0,3,0,0,0};
    assertArrayEquals(expected ,actual);
  }

}
