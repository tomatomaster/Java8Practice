package ch09.ex02;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class Ex02Test extends Ex02 {

  @Test
  public void test() throws FileNotFoundException, IOException {
    Ex02 test = new Ex02();
    String in = "res/ex09/ex01.txt";
    String out= "res/ex09/test02.out";
    test.solve(new Scanner(Paths.get(in)), new PrintWriter(Paths.get(out).toFile()));
    List<String> expected = Arrays.asList("test","test","end");
    List<String> actual = Files.readAllLines(Paths.get(out));
    assertThat(actual, is(expected));
  }
  
  @Test
  public void test02() {
    Ex02 test = new Ex02();
    
  }
  
  private static class ScannerMock extends Scanner {
    
  }

}
