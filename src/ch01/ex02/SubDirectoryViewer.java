package ch01.ex02;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;


final public class SubDirectoryViewer {
  
  public static void main(String[] args) {
    File rootDir = new File("res");
    new SubDirectoryViewer().showSubDirectory(rootDir);
  }
  
  public void showSubDirectory(File directory) {
    File[] subDirectories = directory.listFiles(path -> {
      if(path.isDirectory()) {
        System.out.println(path.getName());
        return true;
      }
      return false;
    });
    for(final File subDirectory : subDirectories) {
      showSubDirectory(subDirectory);
    }
  }
  
  public void methodRefarence(File directory) {
    File[] subDirectories = directory.listFiles(SubDirectoryViewer::forMethodRefarenceMethod);
  }
  
  static boolean forMethodRefarenceMethod(File path, String test) {
    if(path.isDirectory()) {
      System.out.println(path.getName());
      forMethodRefarenceMethod(path, "");
      return false;
    }
    return true;
  }
  
  
 }
