package ch05.ex08;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TimeZoneOffSetTest {

  @Test
  public void testGetOffSet() {
    TimeZoneOffSet timeZone = new TimeZoneOffSet();
    long actual = timeZone.getOffSet("Asia/Tokyo");
    long expected = 0;
    assertThat(actual, is(expected));
  }
  
  @Test
  public void testGetOffSetAmerica() {
    TimeZoneOffSet timeZone = new TimeZoneOffSet();
    long actual = timeZone.getOffSet("America/Guayaquil");
    long expected = 10;
    assertThat(actual, is(expected));
  }

}
