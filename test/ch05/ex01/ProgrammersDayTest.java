package ch05.ex01;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import org.junit.Test;

public class ProgrammersDayTest {
  
  

  @Test
  public void うるう年では無い年のテスト() {
    LocalDate date = LocalDate.of(1988, 1, 1);
    LocalDate expected = LocalDate.of(1988, 9, 13);
    LocalDate actual = ProgrammersDay.getProgrammersDay(date);
    assertThat(actual, is(expected));
  }
  
  @Test
  public void うるう年のテスト() {
    LocalDate leapYear = LocalDate.of(1989, 1, 1);
    LocalDate expected = LocalDate.of(1989, 9, 12);
    LocalDate actual = ProgrammersDay.getProgrammersDay(leapYear);
    assertThat(actual, is(expected));
  }

}
