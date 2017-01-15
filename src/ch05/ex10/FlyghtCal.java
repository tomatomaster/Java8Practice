package ch05.ex10;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class FlyghtCal {
  
  public static void main(String[] args) {
    LocalTime flightTime = LocalTime.of(5, 0);
    ZoneId aZoneId = ZoneId.of("America/Los_Angeles");
    ZonedDateTime result = new FlyghtCal().calTime(ZonedDateTime.now(), flightTime, aZoneId);
    System.out.println(result);
  }

  public ZonedDateTime calTime(ZonedDateTime zLeave, LocalTime flightTime, ZoneId zArrive) {
    ZonedDateTime time = zLeave.plusHours(flightTime.getHour()).plusMinutes(flightTime.getMinute());
    return ZonedDateTime.ofInstant(time.toInstant(), zArrive);
  }
}
