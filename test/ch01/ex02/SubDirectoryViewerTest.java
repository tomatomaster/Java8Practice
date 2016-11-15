package ch01.ex02;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ch01.ex02.SubDirectoryViewer;

public class SubDirectoryViewerTest {

  @Test
  public void testShowSubDirectory() throws Exception {
    new SubDirectoryViewer().showSubDirectory(new File("res"));
    String expected = fileToString(new BufferedReader(new FileReader(new File("res","test.rtf"))));
    String actual = outContent.toString();//getSysout String
    assertEquals(expected, actual);
  }
  
  private String fileToString(BufferedReader bReader) {
    String line = null;
    StringBuilder sb = new StringBuilder();
    try {
      while((line =bReader.readLine()) != null) {
        sb.append(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return sb.toString();
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
