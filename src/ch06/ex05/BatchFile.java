package ch06.ex05;


import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.google.common.base.Charsets;
import com.google.common.io.Files;


public class BatchFile {

  public static void main(String[] args) {
    Map<String, File> result = new BatchFile().getWordsMap(new File("res"));
    for (String word : result.keySet()) {
      System.out.println(word + " " + result.get(word));
    }
  }

  ConcurrentHashMap<String, File> getWordsMap(File directory) {
    ConcurrentHashMap<String, File> result = new ConcurrentHashMap<>();
    Arrays.stream(directory.listFiles()).filter(f -> f.isFile()).parallel().forEach(file -> {
      try {
        Files.readLines(file, Charsets.UTF_8).forEach(line -> {
          for (String word : line.split(" ")) {
            result.merge(word, file, (oFile, nFile) -> nFile);
          }
        });
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
    return result;
  }

}
