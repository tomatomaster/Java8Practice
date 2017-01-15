package ch05.ex03;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Predicate;

public class Adjuster {
  
  LocalDate date;
  
  public Adjuster(LocalDate date) {
    this.date = date;
  }
  
  public static void main(String[] args) {
    LocalDate today = LocalDate.now();
    //1(Mon),2(Thu),3(Wed),4(Thr),5(Fri)
    LocalDate workDay = today.with(next(w -> w.getDayOfWeek().getValue() < 6));
    System.out.println(workDay);
  }

  static TemporalAdjuster next(Predicate<LocalDate> predicate) {
    return TemporalAdjusters.ofDateAdjuster(w -> {
      do {
        w = w.plusDays(1);  
      } while(predicate.test(w));
      return w;
    });
  }
}
