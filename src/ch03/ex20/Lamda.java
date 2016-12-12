package ch03.ex20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Lamda {

  public static void main(String[] args) {
    List<String> stringList;
    List<Integer> intList = Arrays.asList(1, 2, 4, 5, 6);

    stringList = map(intList, (data) -> {
      return String.valueOf(data);
    });

    for (final String s : stringList) {
      System.out.println(s + " Type of " + s.getClass().getTypeName());
    }
  }

  static <T, U> List<U> map(List<T> data, Function<T, U> function) {
    List<U> list = new ArrayList<U>();
    for (final T d : data) {
      list.add(function.apply(d));
    }
    return list;
  }
}
