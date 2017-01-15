package ch05.ex02;

import java.time.LocalDate;

/**
 * うるう日(2/29)に一年を足して非うるう年のLocalDateを取得すると、
 * 2/28になる。
 * 4年後のうるう年ならば2/29になる。
 *
 */
public class AddYear {

  private static LocalDate leapDay = LocalDate.of(2000, 2, 29);
  public static void main(String[] args) {
    LocalDate plus1Year = leapDay.plusYears(1);
    System.out.println(plus1Year);
    LocalDate plus4Year = leapDay.plusYears(4);
    System.out.println(plus4Year);
  }
}
