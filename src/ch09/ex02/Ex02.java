package ch09.ex02;

import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ex02 {

  public void solve(Scanner in, PrintWriter out) {
    Exception ex = null;
    try {
      while (in.hasNext())
        out.println(in.next().toLowerCase());
    } catch (IllegalStateException | NoSuchElementException e) {
      ex = e;
    } finally {
      try {
        if (out != null)
          out.close();
        if (in != null)
          in.close();
      } catch (Exception e) {
        if (ex != null) {
          ex.addSuppressed(e);
        }
      }
    }
  }
}
