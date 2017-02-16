package ch08.ex10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Ex10 {
  public static void main(String[] args) throws IOException {
    final Path res = Paths.get("res", "src");
    try (Stream<Path> entries = Files.walk(res)) {
      entries.filter(e -> !Files.isDirectory(e)).forEach(entry -> {
        try {
          Files.readAllLines(entry).stream().forEach(l -> {
            if (l.contains("transient") || l.contains("volatile")) {
              System.out.printf("Find at [%s] \n %s\n\n",l,entry);
            }
          });
        } catch (Exception e) {
          e.printStackTrace();
        }
      });
    }
  }
}
