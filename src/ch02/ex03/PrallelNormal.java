package ch02.ex03;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class PrallelNormal {
  static List<String> words;

  static {
    String contents = null;
    try {
      contents = new String(Files.readAllBytes(Paths.get("res/war.txt")), StandardCharsets.UTF_8);
    } catch (IOException e) {
      e.printStackTrace();
    }
    words = Arrays.asList(contents.split("\\P{L}+"));
  }
  
  public static void main(String[] args) {
    benchMark();
  }
  
  static void benchMark() {
    parallel();
    normal();
  }

  public static long parallel() {
    long start = System.nanoTime();
    long result = words.parallelStream().filter(w->w.length() > 17).count();
    long end = System.nanoTime();
    System.out.printf("PrallelStream Time: %d Count: %d %n",end - start, result);
    return result;
  }
  
  public static long normal() {
    long start = System.nanoTime();
    long result = words.stream().filter(w->w.length() > 17).count();
    long end = System.nanoTime();
    System.out.printf("NormalStream Time: %d Count: %d %n",end - start, result);
    return result;
  }
}
