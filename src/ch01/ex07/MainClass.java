package ch01.ex07;

public class MainClass {

  public static void main(String[] args) {
    new Thread(andThen(() -> {
      System.out.println("zzz");
      try {
        Thread.sleep(1000);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }, () -> {
      System.out.println("wakeUp");
    })).run();
  }

  static Runnable andThen(Runnable run1, Runnable run2) {
    run1.run();
    return run2;
  }
}
