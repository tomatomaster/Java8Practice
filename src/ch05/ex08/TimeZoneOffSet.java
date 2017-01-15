package ch05.ex08;

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
    System.out.println(ZoneId.systemDefault().getDisplayName(TextStyle.FULL, Locale.JAPAN) + "と各国の時刻差");
    ZoneId.getAvailableZoneIds().stream().forEach(timeZoneId -> {
      ZoneId zoneId = ZoneId.of(timeZoneId);
      LocalTime now = LocalTime.now();
      LocalTime timeZone = LocalTime.now(zoneId);
      long offSet = ChronoUnit.HOURS.between(now, timeZone);
      System.out.printf("%s %d \n", zoneId.getDisplayName(TextStyle.FULL, Locale.JAPAN), offSet);
    });
  }
}
