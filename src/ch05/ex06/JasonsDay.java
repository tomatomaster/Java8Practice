package ch05.ex06;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class JasonsDay {
  
  public static void main(String[] args) {
    System.out.println(new JasonsDay().count13Friday());
  }

  public int count13Friday() {
    LocalDate date = LocalDate.of(1901, 1, 1);
    int counter = 0;
    do {
      date = date.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
      int day = date.getDayOfMonth();
      if(day == 13) {
        counter++;
      }
    } while(date.getYear() < 2001);
    return counter;
  }
}
