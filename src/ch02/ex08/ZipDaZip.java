package ch02.ex08;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ZipDaZip {

  public static void main(String[] args) {
    String[] words1 = {"test","ganmbaru","man"};
    String[] words2 = {"AA","BB","CC"};
    zip(Stream.of(words1), Stream.of(words2)).forEach(System.out::println);
  }
  
  public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
    List<T> list = new ArrayList<T>();
    first.forEach(firstElement -> {
      if (firstElement == null)
        return;
      list.add(firstElement);
      second.forEach(secondElement -> {
        if (secondElement == null)
          return;
        list.add(secondElement);
        zip(first, second);
      });
    });
    return list.stream();
  }

}
