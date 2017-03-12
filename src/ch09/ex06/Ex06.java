package ch09.ex06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;

public class Ex06 {
  public static void main(String[] args) throws IOException {
    Path in = Paths.get("res", "war.txt");
    Path out= Paths.get("res", "to", "outLine.txt");
    writeReverse(in, out);
  }

  /**
   * 
   * 
   * @param in source file path
   * @param to output file path
   * @throws IOException if path, in or to, not exists throw.
   */
  public static void writeReverse(Path in, Path to) throws IOException {
    List<String> lines = Files.readAllLines(in);
    Collections.reverse(lines);
    Files.write(to, lines, StandardOpenOption.CREATE, StandardOpenOption.WRITE);  
  }
}
