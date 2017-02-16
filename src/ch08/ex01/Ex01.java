package ch08.ex01;

public class Ex01 {

  private static short s1 = Short.MAX_VALUE;
  private static short s2 = Short.MAX_VALUE;

  public static void main(String[] args) {
    String unValue = "4294967295";
    int aResult;
    try {
      aResult = add(unValue, unValue);  
    } catch (NumberFormatException e) {
      if(e.getMessage().contains("-")) {
        aResult = Integer.MIN_VALUE;
      } else {
        aResult = Integer.MAX_VALUE;
      }
    }
    System.out.println(aResult);
    int result = divide(unValue, unValue);
    System.out.println(result);
  }

  public static int add(String a1, String a2) {
    Long result = Long.parseUnsignedLong(a1) + Long.parseUnsignedLong(a2);
    return Integer.parseUnsignedInt(result.toString());
  }

  public static int divide(String a1, String a2) {
    return Integer.divideUnsigned(Integer.parseUnsignedInt(a1), Integer.parseUnsignedInt(a2));
  }

  public static int compare(String a1, String a2) {
    return Integer.compareUnsigned(Integer.parseUnsignedInt(a1), Integer.parseUnsignedInt(a2));
  }
}
