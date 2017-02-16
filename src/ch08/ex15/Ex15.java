package ch08.ex15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class Ex15 {
public static void main(String[] args) throws IOException {
  Path path = Paths.get("res","src","java","awt","Color.java");
  String rexp = "(private)";
  Files.lines(path).filter(line-> Pattern.compile(rexp).asPredicate().test(line)).forEach(System.out::println);
}


}
