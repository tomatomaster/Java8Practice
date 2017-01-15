package ch05.ex05;

import java.time.LocalDate;
import java.time.Period;

public class TheLife {
  
  public static void main(String[] args) {
    LocalDate mybirthday = LocalDate.of(1988, 7, 14);
    System.out.println(count(mybirthday));
  }

  public static int count(LocalDate birthDay) {
    LocalDate today = LocalDate.now();
    int sumOfLeapYear = coutLeapYear(birthDay, today);
    Period period = Period.between(birthDay, today);
    return (period.getYears() - sumOfLeapYear) * 365 + sumOfLeapYear*366; 
  }

  public static int coutLeapYear(LocalDate start, LocalDate end) {
    Period period = Period.between(start, end);
    int count = 0;
    for(int i=0; i < period.getYears(); i++) {
      if(start.plusYears(i).isLeapYear()) {
        count++;
      }
    }
    return count;
  }
}
