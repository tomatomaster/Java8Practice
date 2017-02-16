package ch08.ex03;

public class Ex03 {

  public static void main(String[] args) {
    System.out.println(gcd(281231314, -213122));
    System.out.println(gcd2(281231314,-213122));
    System.out.println(gcd3(281231314,-213122));
  }
  
  public static int gcd(int a, int b) {
    if(b==0) {
      return a;
    }
    return gcd(b, rem(a,b));
  }
  
  public static int gcd2(int a, int b) {
    if(b==0) {
      return a;
    }
    return gcd(b, per(a, b));
  }
  
  public static int gcd3(int a, int b) {
    if(b==0) {
      return a;
    }
    return gcd(b, floor(a, b));
  }
   
  private static int per(int a, int b) {
    if(a<0) {
      a = Math.negateExact(a);
    }
    return a%b;
  }
  
  private static int floor(int a, int b) {
    if(b<0) {
      b = Math.negateExact(b);
    }
    return Math.floorMod(a, b);
  }
  
  public static int rem(int a, int b) {
    return Math.abs(a%b);
  }
}
