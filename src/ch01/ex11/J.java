package ch01.ex11;

public interface J {
  abstract void abstractMethod();
  
  static void staticMethod() {
    System.out.println("Static Method");
  };
  
/*  default void defaultMethod() {
    System.out.println("default Method");
  }*/
}
