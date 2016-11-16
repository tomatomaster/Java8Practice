package ch01.ex04;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class FileSorterTest {

  @Test
  public void testSort() {
    File[] files = new File("res").listFiles();
    FileSorter.sort(files);
    for(int i = 0; i < files.length; i++) {
      if(files[i].isFile()) {
        for(int j=i; j < files.length; j++) {
          if(files[j].isDirectory())
            fail();
        }
        return;
      }
    }
  }

}
