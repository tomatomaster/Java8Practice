package ch03.ex17;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FunctionalAsync {

  public static void main(String[] args) {

    Runnable run = new Runnable() {
      @Override
      public void run() {
        ExceptionThrower e = new ExceptionThrower();
        System.out.println(Thread.currentThread().getId());
        e.doThrowException();
      }
    };

    Runnable run2 = new Runnable() {
      @Override
      public void run() {
        ExceptionThrower e = new ExceptionThrower();
        System.out.println(Thread.currentThread().getId());
        e.doThrowException();
      }
    };

    Consumer<Throwable> handler = new Consumer<Throwable>() {
      @Override
      public void accept(Throwable t) {
        System.out.println("Catch Exception !! " + t.getClass().getCanonicalName());
      }
    };

    doInParallelAsync(run, run2, handler);
  }

  public static <T> void doInOrderAsync(Supplier<T> doThing,
      BiConsumer<T, Consumer<Throwable>> thenThing, Consumer<Throwable> handler) {
    Thread thread = new Thread() {
      public void run() {
        T result = null;
        try {
          result = doThing.get();

        } catch (Throwable t) {
          handler.accept(t);
        }
        thenThing.accept(result, handler);
      };
    };
    thread.run();
  }


  public static <T> void doInParallelAsync(Runnable run1, Runnable run2,
      Consumer<Throwable> handler) {

    Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    executor.execute(new Runnable() {
      @Override
      public void run() {
        try {
          run1.run();
        } catch (Throwable t) {
          handler.accept(t);
        }
      }
    });
    
    executor.execute(new Runnable() {
      @Override
      public void run() {
        try {
          run2.run();
        } catch (Throwable t) {
          handler.accept(t);
        }
      }
    });
  }


  private static class ExceptionThrower {
    public void doThrowException() {
      throw new IllegalAccessError("test");
    }
  }
}
