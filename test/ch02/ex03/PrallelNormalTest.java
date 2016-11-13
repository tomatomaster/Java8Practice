package ch02.ex03;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrallelNormalTest {
  
  @Test
  public void testParallel() {
    assertEquals(3, PrallelNormal.parallel());
  }

  @Test
  public void testNormal() {
    assertEquals(3, PrallelNormal.normal());
  }

}
