package ch01.ex04;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileSorter {
  public static void main(String[] args) {
    File file = new File("res");
    File[] files = file.listFiles();
    System.out.println("Before");
    for(final File f : files) {
      System.out.println(f.getName());
    }
    System.out.printf("%nAfter%n");
    files = FileSorter.sort(files);
    for(final File f : files) {
      System.out.println(f.getName());
    }
  }

  public static File[] sort(File[] files) {
    List<File> list = Arrays.asList(files); 
    list.sort((file1, file2) -> {
      if (file1.isDirectory() && file2.isFile()) {
        return -1;
      } else if(file1.isFile() && file2.isDirectory()) {
        return 1;
      } else if (file1.isDirectory() && file2.isDirectory()) {
        return file1.getName().compareTo(file2.getName());
      } else if (file1.isFile() && file1.isFile()) {
        return file1.getName().compareTo(file2.getName());
      }
      return 0;
    });
    return list.toArray(new File[0]);
  }
}
