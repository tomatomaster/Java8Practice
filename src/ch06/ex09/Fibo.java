package ch06.ex09;

import java.util.Arrays;

public class Fibo {

  Integer[][] matrix = new Integer[2][2];
  
  public static void main(String[] args) {
    Integer[][] values = new Integer[2][2];
    Arrays.parallelSetAll(values[0], i -> 1);
    Arrays.parallelSetAll(values[1], i -> i==0?1:0);
    Arrays.parallelPrefix(values[0], Matrix::multi);
    
  }


  private static class Matrix {

    public static Integer[][] multi(Integer[][] m1, Integer[][] m2) {
      Integer zerozero = m1[0][0] * m2[0][0] + m1[0][1] * m2[1][0];
      Integer zeroone = m1[0][0] * m2[0][1] + m1[0][1] * m2[1][1];
      Integer onezero = m1[0][1] * m2[0][1] + m1[1][1] * m2[1][0];
      Integer oneone = m1[1][0] * m2[0][1] + m1[1][1] * m2[1][1];
      Integer[][] result = {{zerozero, zeroone}, {onezero, oneone}};
      return result;
    }
  }
}
