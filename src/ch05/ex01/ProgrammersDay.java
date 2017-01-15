package ch05.ex01;

import java.time.LocalDate;

public class ProgrammersDay {

  public static void main(String[] args) {
    LocalDate dateOf = LocalDate.of(1988, 12, 31);
    System.out.println(getProgrammersDay(dateOf));
  }
  
  /**
   * プログラマーの日（一年の256日目）を取得する
   * 9月13日、うるう年ならば9月12日を返す 
   * 
   * @param date
   * @return
   */
  public static LocalDate getProgrammersDay(LocalDate date) {
    final int INDEX_PROGRAMMERS_DAY = 256;
    final int DAYS_YEAR = 365;
    LocalDate lastDateOfYear = LocalDate.of(date.getYear(), 12, 31);
    LocalDate programmersDay;
    if(date.isLeapYear()) {
      //programmersDay = LocalDate.of(date.getYear(), 9, 13);
      programmersDay = lastDateOfYear.minusDays(DAYS_YEAR - INDEX_PROGRAMMERS_DAY);
    } else {
      //programmersDay = LocalDate.of(date.getYear(), 9, 12);
      programmersDay = lastDateOfYear.minusDays((DAYS_YEAR + 1) - INDEX_PROGRAMMERS_DAY);
    }
    return programmersDay;
  }
}
