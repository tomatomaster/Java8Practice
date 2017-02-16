package ch08.ex16;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex16 {

  public static void main(String[] args) {
    String add = "Washington, DC 20500";
    String err = "Washington, DCDC 20500";
    String s = "(?<city>[\\p{L} ]+), \\s*(?<state>[A-Z]{2} \\s*[0-9]{5})";
    Pattern pattern = Pattern.compile(s);
    Matcher matcher = pattern.matcher(add);
    Matcher matcher2= pattern.matcher(err);
    boolean r = matcher.find();
    boolean r2= matcher2.find();
    System.out.printf("add result: %b \nerr result: %b",r,r2);
  }
}
