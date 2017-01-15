package ch05.ex07;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class TimeInterval {
  LocalDate date;
  Duration duration;
  
  public TimeInterval(LocalDate date, Duration duration) {
    this.date = date;
    this.duration = duration;
  }
  
  public int isOverlaped(TimeInterval interval) {
    int r = interval.date.compareTo(date);
    if(r == 0) {
      duration.
      return this.duration.compareTo(interval.duration);  
    } else {
      return r;
    }
  }
  
  public static void main(String[] args) {
    Duration duration1 = Duration.between(LocalTime.of(11, 00), LocalTime.of(12, 00));
    Duration duration2 = Duration.between(LocalTime.of(10, 00), LocalTime.of(10, 50));
    TimeInterval timeIntervale1 = new TimeInterval(LocalDate.now(), duration1);
    TimeInterval timeIntervale2 = new TimeInterval(LocalDate.now(), duration2);
    System.out.println(timeIntervale1.isOverlaped(timeIntervale2));
  }
}
