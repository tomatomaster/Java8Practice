package ch06.ex06;


import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

/**
 * Q:mergeではなく、computeIfAbsentを利用する利点とは
 * A:mergeは古い値が存在する場合毎回remappingFunctionが評価されるが、<br>
 * computeIfAbsentならば、初期値が存在しない場合のみmappingFunctionが評価される。
 *
 */
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
            result.computeIfAbsent(word, w-> file);
          }
        });
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
    return result;
  }

}
