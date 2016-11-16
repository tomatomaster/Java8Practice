package ch02.ex12;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.stream.Stream;

public class AtomicIntegerParallel {

  private static AtomicIntegerArray atomicIntegerArray;
  
  public static void main(String[] args) {
    String[] words = {"yaruki","genki","iwaki","nobuko"};
    method(words);
  }

  synchronized public static void method(String[] words) {
    atomicIntegerArray = new AtomicIntegerArray(5);
    Stream<String> stream = Stream.of(words);
    stream.parallel().forEach(word->{
      if(word.length() < 5) {
        atomicIntegerArray.getAndIncrement(word.length());
      }
    });
  }
  
  synchronized public static int[] getAtomcInteger() {
    int[] array = new int[atomicIntegerArray.length()];
    for(int i = 0; i < atomicIntegerArray.length(); i++){
      array[i] = atomicIntegerArray.get(i);
    }
    return array;
  }
}
