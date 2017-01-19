package ch05.ex03;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import org.junit.Test;

public class AdjusterTest {

  @Test
  public void testNext() {
    LocalDate jOne2016 = LocalDate.of(2016, 1, 1);
    // 1(Mon),2(Thu),3(Wed),4(Thr),5(Fri)
    LocalDate actual = jOne2016.with(Adjuster.next(w -> w.getDayOfWeek().getValue() < 6));
    LocalDate expected= LocalDate.of(2016, 1, 2);
    assertThat(actual, is(expected));
  }

}
