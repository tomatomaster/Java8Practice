package ch05.ex04;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class CalendarCommand {

  public static void main(String[] args) {
    LocalDate today = LocalDate.of(LocalDate.now().getYear(), 1, 1);
    for(int i = 0; i < 12; i++) {
      System.out.print(Month.of(LocalDate.of(today.getYear(), i + 1, 1).getMonthValue()));
      new CalendarCommand().show(today.plusMonths(i));
      System.out.println();
    }
  }
  
  public void show(LocalDate date) {
    int firstDayOfMonth = date.with(TemporalAdjusters.firstDayOfMonth()).getDayOfWeek().getValue();
    int lastDayOfMonth = date.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
    int printDay = 1;
    for(int i=0; i < lastDayOfMonth + firstDayOfMonth; i++) {
      if(i < firstDayOfMonth) {
        System.out.print("   ");
      } else {
        if(printDay < 10) {
          System.out.print(" " + printDay++ + " ");  
        } else {
          System.out.print(printDay++ + " ");
        }
      }
      if(i%7==0) {
        System.out.println("");
      }
    }
  }
}
