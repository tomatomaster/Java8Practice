package ch02.ex01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.sun.org.apache.xalan.internal.utils.FeatureManager.Feature;
import com.sun.org.apache.xalan.internal.xsltc.CollatorFactory;

public class Stream {
  static List<String> words;

  static {
    String contents = null;
    try {
      contents = new String(Files.readAllBytes(Paths.get("res/alice.txt")), StandardCharsets.UTF_8);
    } catch (IOException e) {
      e.printStackTrace();
    }
    words = Arrays.asList(contents.split("\\P{L}+"));
  }

  long sampleMethod() {
    long count = words.parallelStream().filter(w -> w.length() > 12).count();
    return count;
  }

  public static void main(String[] args) {
    try {
      parallelStreamSample();
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }

  static void parallelStreamSample() throws InterruptedException, ExecutionException {
    final int THREAD_SIZE = 6;
    ExecutorService executor = Executors.newFixedThreadPool(THREAD_SIZE);
    List<String> subList;
    int perSize = words.size() / THREAD_SIZE;

    List<Future<Long>> futures = new ArrayList<Future<Long>>();
    for (int i = 0; perSize < words.size(); perSize = perSize*i) {
      subList = words.subList(i, perSize);
      futures.add(executor.submit(new CountTask(subList)));
      i = perSize;
    }

    long count = 0;
    for (final Future<Long> future : futures) {
      count = future.get();
    }
    System.out.println(count);
  }

  private static class CountTask implements Callable<Long> {

    List<String> list;

    public CountTask(List<String> list) {
      this.list = list;
    }

    @Override
    public Long call() throws Exception {
      long count = 0;
      for (String element : list) {
        if (element.length() > 12)
          count++;
      }
      return count;
    }
  }

}


