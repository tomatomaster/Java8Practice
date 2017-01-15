package ch05.ex07;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Test;

public class TimeIntervalTest {
  LocalTime time10 = LocalTime.of(10, 00);
  LocalTime time11 = LocalTime.of(11, 00);
  LocalTime time12 = LocalTime.of(12, 00);
  LocalTime time13 = LocalTime.of(13, 00);
  LocalTime time14 = LocalTime.of(14, 00);
  Duration duration1011 = Duration.between(time10, time11);
  Duration duration1012 = Duration.between(time10, time12);
  Duration duration1314 = Duration.between(time13, time14);
  LocalDate jounuary1 = LocalDate.of(2000, 1, 1);
  LocalDate jounuary2 = LocalDate.of(2000, 1, 2);
  
  
  @Test
  public void testIsOverlapedSame() {
    TimeInterval interval = new TimeInterval(jounuary1, duration1011);
    int actual = interval.isOverlaped(interval);
    int expected = 0;
    assertThat(actual, is(expected));
  }
  
  @Test
  public void 期間よりも前の時間と比較する場合() {
    TimeInterval interval = new TimeInterval(jounuary1, duration1314);
    TimeInterval intervalPrevious = new TimeInterval(jounuary1, duration1011);
    int actual = interval.isOverlaped(intervalPrevious);
    int expected = -1;
    assertThat(actual, is(expected));
  }

}
