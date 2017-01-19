package ch05.ex05;

import java.time.LocalDate;

import org.junit.Test;

public class TheLifeTest {

  @Test
  public void testCount() {
    long day = new TheLife().countDay(LocalDate.of(1988, 7, 14));
    System.out.println(day);
  }

}
