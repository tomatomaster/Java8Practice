package ch06.ex08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 3,4程度
 * 
 */
public class WhichIsFaster {
  
  
  
  public static void main(String[] args) {
    new WhichIsFaster().test();
  }
  
  public void test() {
    long sortTime;
    long parallelSortTime;
    int size = 2;
    do {
    List<Integer> intList = new ArrayList<>();
    new Random().ints(size).forEach(i -> intList.add(i));
    Integer[] intArray = intList.toArray(new Integer[size]);
    long t1 = System.currentTimeMillis();
    Arrays.sort(intArray);
    long t2 = System.currentTimeMillis();
    Arrays.parallelSort(intArray);
    long t3 = System.currentTimeMillis();
    sortTime = t2-t1;
    parallelSortTime = t3-t2;
    size++;
    } while(parallelSortTime > sortTime);
    System.out.println(size);
  }
  

}
