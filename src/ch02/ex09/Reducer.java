package ch02.ex09;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reducer {

  public static void main(String[] args) {
    ArrayList<String> arrayList = new ArrayList<>();
    arrayList.add("yaruki");
    arrayList.add("genki");
    Stream stream = Stream.of(arrayList);
    reducer1(stream).forEach(System.out::println);
  }

  public static <T> ArrayList<T> reducer1(Stream<ArrayList<T>> stream) {
    return stream.reduce((list1, list2) -> {
      list1.addAll(list2);
      return list1;
    }).get();
  }

  @SuppressWarnings("unchecked")
  public static <T> ArrayList<T> reducer2(Stream<ArrayList<T>> stream) {
    return stream.reduce(new ArrayList(Arrays.asList("ETERNAL")), (list1, list2) -> {
      list1.addAll(list2);
      return list1;
    });
  }

  @SuppressWarnings("unchecked")
  public static <T> ArrayList<T> reducer3(Stream<ArrayList<T>> stream) {
    return stream.reduce(new ArrayList(Arrays.asList("ETERNAL")), (sumOfList, list2) -> {
      sumOfList.addAll(list2);
      return sumOfList;
    } , (sumOfList1, sumOfList2) -> {
      sumOfList1.addAll(sumOfList2);
      return sumOfList1;
    });
  }


}
