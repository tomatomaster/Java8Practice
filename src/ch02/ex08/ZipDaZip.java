package ch02.ex08;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 
 * ???
 *
 */
public class ZipDaZip {

  public static void main(String[] args) {
    String[] words1 = {"test","ganmbaru","man"};
    String[] words2 = {"AA","BB","CC"};
    zip(Stream.of(words1), Stream.of(words2)).forEach(System.out::println);
  }
  
}
