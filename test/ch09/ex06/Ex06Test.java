package ch09.ex06;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Ex06Test {

  @Test
  public void testWriteReverse() throws IOException {
    Ex06 test = new Ex06();
    Path in = Paths.get("res", "ex06", "sample06.txt");
    Path to = Paths.get("res", "ex06" , "out.txt");
    test.writeReverse(in, to);
    List<String> actual = Files.readAllLines(to);
    List<String> expected = Arrays.asList("abcdefghij","0123456789");
    assertThat(actual, is(expected));
  }

}
