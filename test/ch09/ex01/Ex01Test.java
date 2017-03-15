package ch09.ex01;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Ex01Test {

  @Test
  public void testSolve() throws IOException {
    Ex01 test = new Ex01();
    String in = "res/ex09/ex01.txt";
    String out = "res/ex09/test.out";
    List<String> expected = Arrays.asList("test","test","end");
    test.solve(in, out);
    List<String> actual = Files.readAllLines(Paths.get(out));
    assertThat(actual, is(expected));
  }

}
