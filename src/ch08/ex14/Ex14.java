package ch08.ex14;

import java.util.Objects;

public class Ex14 {
  public static void main(String[] args) {
    Object obj = null;
    Objects.requireNonNull(obj, "obj is null. Expected value is 'A' or 'B'.");
  }
}
