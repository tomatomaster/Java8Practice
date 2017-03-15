package ch09.ex05;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class Ex05Test {

  @Test
  public void testWriteReverse() throws IOException {
    Ex05 target = new Ex05();
    Path in = Paths.get("res", "ex05", "sample05.txt");
    Path to = Paths.get("res", "ex05" , "out.txt");
    target.writeReverse(in, to);
    String actual = Files.readAllLines(to).get(0);
    String expected = "9876543210";
    assertThat(actual, is(expected));
  }

}
