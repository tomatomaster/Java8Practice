package ch09.ex07;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex07 {

  public static void main(String[] args) throws IOException {
    Path p = Paths.get("res", "to", "url.txt");
    URL url = new URL("http://www.google.com");
    writeContentsFrom(url, p);
  }
  
  static void writeContentsFrom(URL page, Path to) throws IOException {
    Files.copy(page.openStream(), to);
  }
}
