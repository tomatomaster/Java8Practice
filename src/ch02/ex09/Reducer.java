package ch02.ex09;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reducer {

  public static <T> ArrayList<T> convertToArrayListByUsingListForEachMethod(Stream<ArrayList<T>> stream) {
    ArrayList<T> result = new ArrayList<>();
    stream.forEach(list -> list.forEach(result::add));
    return result;
  }
  
  public static <T> ArrayList<T> convertToArrayListByUsingCollect(Stream<ArrayList<T>> stream) {
    stream.flatMap(list -> );
  }
}
