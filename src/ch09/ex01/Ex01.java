package ch09.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ex01 {
  public static void main(String[] args) throws IOException {

  }

  public void solve(String readPath, String writePath) throws IOException {
    Scanner in = null;
    PrintWriter out = null;
    try {
      in = new Scanner(Paths.get(readPath));
      out = new PrintWriter(writePath);
      while (in.hasNext())
        out.println(in.next().toLowerCase());
    } finally {
      if (out != null)
        out.close();
      if (in != null)
        in.close();
    }
  }

  public static void original() throws IOException {
    try (Scanner in = new Scanner(Paths.get("/s/s")); PrintWriter out = new PrintWriter("")) {
      while (in.hasNext())
        out.println(in.next().toLowerCase());
    }
  }
}
