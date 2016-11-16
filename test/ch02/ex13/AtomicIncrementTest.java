package ch02.ex13;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class AtomicIncrementTest {

  @Test
  public void testMethod() {
    Map<Integer, Long> expected = new HashMap<>();
    expected.put(2, 1L);
    expected.put(4, 3L);
    String[] words = {"sono","ii","aruk","naik"};
    Map<Integer, Long> actual = AtomicIncrement.method(words);
    assertEquals(expected, actual);
  }

}
