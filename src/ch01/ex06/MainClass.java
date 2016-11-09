package ch01.ex06;

public class MainClass {
public static void main(String[] args) {
  new Thread(uncheck(()->{
    System.out.println("zzz");
    Thread.sleep(1000);
    System.out.println("wakeUp");
  })).run();
}

public static Runnable uncheck(RunnableEx runable) {
  try {
    runable.run();
  } catch (Exception e) {
    throw new RuntimeException(e);
  }
  return null;
}
}
