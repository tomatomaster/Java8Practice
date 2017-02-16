package ch08.ex05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex05 {

  public static void main(String[] args) {
    String longWords = "abcdefghijklmnopqlstu";
    String longWords2= longWords + "12345";
    List<String> words = new ArrayList(Arrays.asList(longWords,longWords2,"test","test1","test2"));
    for(int i=0; i<1000000; i++) {
      words.add(longWords2);
    }
    long i = System.currentTimeMillis();
    long size = words.stream().filter(w -> w.length() > 12).count();
    long j = System.currentTimeMillis();
    words.removeIf(w -> w.length() <= 12);
    int  size2= words.size();
    long k = System.currentTimeMillis();
    System.out.printf("Time(filter): %d Time(removeIf): %d", j-i, k-j);
  }
}
