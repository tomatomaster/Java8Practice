package ch03.ex21;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

public class Lamda {

  public static void main(String[] args) {
    Future<String> future = Executors.newCachedThreadPool().submit(() -> {
      return "abcdefghijklemn";
    });

    Function<String, Integer> function = new Function<String, Integer>() {
      @Override
      public Integer apply(String t) {
        return t.length();
      }
    };

    try {
      Future<Integer> futureResult = map(future, function);
      int getValue = futureResult.get();
      System.out.println(getValue);
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }

  }

  static <T, U> Future<U> map(Future<T> future, Function<T, U> function) {
    return new Future<U>() {

      @Override
      public boolean cancel(boolean mayInterruptIfRunning) {
        return future.cancel(mayInterruptIfRunning);
      }

      @Override
      public boolean isCancelled() {
        return future.isCancelled();
      }

      @Override
      public boolean isDone() {
        return future.isDone();
      }

      @Override
      public U get() throws InterruptedException, ExecutionException {
        return function.apply(future.get());
      }

      @Override
      public U get(long timeout, TimeUnit unit)
          throws InterruptedException, ExecutionException, TimeoutException {
        return function.apply(future.get(timeout, unit));
      }
    };
  }
}
