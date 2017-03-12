package ch09.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ex02 {
  
  public static void solve() {
    Scanner in = null;
    PrintWriter out = null;
    Exception ex = null;
    try {
      in = new Scanner(Paths.get("/s/s"));
      out = new PrintWriter("");
      while (in.hasNext())
        out.println(in.next().toLowerCase());
    } catch (IOException e) {
      ex = e;
    } finally {
      try {
        if (out != null)
          out.close();
        if (in != null)
          in.close();  
      } catch (Exception e) {
        if(ex != null) {
          ex.addSuppressed(e);
        }
      }
    }
  }
}
