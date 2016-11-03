package ch01.ex3;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileFilter {
  
  public static void main(String[] args) {
    List<File> files = new FileFilter().getFiles(new File("res","test3"), "txt");
    for(final File file : files) {
      System.out.println(file);
    }
  }

  public List<File> getFiles(File dir, String ext) {
    File[] subFiles = dir.listFiles(filter -> {
      if(filter.getName().contains("." + ext))
        return true;
      return false;
    });
    return Arrays.asList(subFiles);
  }
}
