package ch02.ex05;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * 
 * @author ono
 *
 */
public class LinearCongruentialGeneratorTest {
  @Test
  public void testGetRandomStream() {
    int border = 100;
    Set<Long> set = new HashSet<Long>();
    
    LinearCongruentialGenerator.getRandomStream(12344141, 132, 234234423).limit(border).forEach(randomValue -> {
      System.out.println(randomValue);
      set.add(randomValue);
    });
    
    System.out.println("Size is " + set.size());
    assertFalse(set.size() < border * 0.90);

  }

}
