package ch09.ex05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Ex05 {
  public static void main(String[] args) throws IOException {
    Path in = Paths.get("res", "war.txt");
    Path out= Paths.get("res", "to", "out.txt");
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
    byte[] b = Files.readAllBytes(in);
    byte[] tob = new byte[b.length];
    for(int i=0; i<b.length; i++) {
      tob[b.length - i -1] = b[i]; 
    }
    Files.write(to, tob, StandardOpenOption.CREATE, StandardOpenOption.WRITE);  
  }
}
