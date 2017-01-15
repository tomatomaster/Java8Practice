package ch05.ex11;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class FlyghtCal2 {
  
  public static void main(String[] args) {
    ZonedDateTime here = ZonedDateTime.now();
    ZonedDateTime america = ZonedDateTime.of(LocalDateTime.of(here.getYear(), here.getMonth(), here.getDayOfMonth(), 10, 00), ZoneId.of("America/Los_Angeles"));
    LocalTime result = new FlyghtCal2().calFlylightTime(here, america);
    System.out.println(result);
  }

  public LocalTime calFlylightTime(ZonedDateTime tLeave, ZonedDateTime tArrive) {
    ZonedDateTime arriveTimeInLeaveZone = ZonedDateTime.of(tArrive.toLocalDateTime(), tLeave.getZone());
    ZonedDateTime time = tLeave.minusHours(arriveTimeInLeaveZone.getHour()).minusMinutes(arriveTimeInLeaveZone.getMinute());
    return time.toLocalTime();
  }
 
}
