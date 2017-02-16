package ch08.ex09;

import java.util.Scanner;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Ex09 {
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    words(scanner).forEach(System.out::println);;
  }

  /**
   * Scannerで読み込んだ文字列を<br>
   * 単語を要素に持つストリームに変換する
   * 
   * @param scanner
   * @return
   */
  public static Stream<String> words(Scanner scanner) {
    return StreamSupport.stream(Spliterators.spliteratorUnknownSize(scanner, Spliterator.ORDERED), false);
  }
}
