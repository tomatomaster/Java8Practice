package ch02.ex02;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FilterCheckTest {

  @Test
  public void test() {
    FilterCheck.forTest();
    List<String> list = Arrays.asList(outContent.toString().split(System.lineSeparator()));
    int count = 0;
    for(String s : list) {
      if(s.equals("==Log=="))
        count++;
    }
    assertEquals(5, count);
  }

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }

  @After
  public void cleanUpStreams() {
    System.setOut(null);
    System.setErr(null);
  }

}
