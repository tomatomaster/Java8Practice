package ch05.ex09;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class TimeZoneOffSet {

  public static void main(String[] args) {
    new TimeZoneOffSet().showAllTimeZoneOffSet();
  }
  
  public void showAllTimeZoneOffSet() {    
    ZoneId.getAvailableZoneIds().stream().filter(timeZoneId -> {
      long offSet = Math.abs(getOffSet(timeZoneId));
      if(offSet < 1) {
        return true;
      } else {
        return false;  
      }
    }).forEach(timeZoneId -> {
      ZoneId zoneId = ZoneId.of(timeZoneId);
      long offSet = getOffSet(timeZoneId);
      System.out.printf("%s %d \n", zoneId.getDisplayName(TextStyle.FULL, Locale.JAPAN), offSet);
    });
  }
  
  private long getOffSet(String timeZoneId) {
    ZoneId zoneId = ZoneId.of(timeZoneId);
    LocalTime now = LocalTime.now();
    LocalTime timeZone = LocalTime.now(zoneId);
    return ChronoUnit.HOURS.between(now, timeZone);
  }
}
