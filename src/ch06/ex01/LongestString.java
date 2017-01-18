package ch06.ex01;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class LongestString {

  String s;
  String longest;
  AtomicReference<Integer> length = new AtomicReference<>(-1);

  public static void main(String[] args) {
    LongestString longest = new LongestString();
    ExecutorService ex = Executors.newCachedThreadPool();
    for (int i = 0; i < 20; i++) {
      ex.execute(()->{
        int value = new Random().nextInt();
        System.out.println(value);
        longest.setString(String.valueOf(value));   
      });
    }
    String result = longest.getLongestString();
    System.out.println("longest " + result);
  }

  String getLongestString() {
    return longest;
  }

  public void setString(String s) {
    this.s = s;
    length.accumulateAndGet(s.length(), (p, n) -> {
      if (n.compareTo(p) > 0) {
        longest = s;
        return n;
      } else {
        return p;
      }
    });
  }
}
