package ch01.ex03;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileFilterTest {

  @Test
  public void testGetFiles() {
    List<File> files = new FileFilter().getFiles(new File("res","test3"), "txt");
    for(final File file : files) {
      System.out.println(file);
    }
   List<String> filePaths = Arrays.asList(outContent.toString().split(System.lineSeparator()));
   for(final String file : filePaths) {
     String actual = file.substring(file.lastIndexOf('.') + 1, file.length());
     assertEquals("txt", actual);
   }
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
