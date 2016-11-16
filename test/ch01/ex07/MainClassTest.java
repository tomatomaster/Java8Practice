package ch01.ex07;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MainClassTest {

  @Test
  public void test() {
    new Thread(MainClass.andThen(() -> {
      System.out.println("zzz");
      try {
        Thread.sleep(1000);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }, () -> {
      System.out.println("wakeUp");
    })).run();
    
    String actual = outContent.toString();
    String expected = "zzz\nwakeUp\n";
    assertEquals(expected, actual);
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
