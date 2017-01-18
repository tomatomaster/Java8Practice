package ch06.ex11;

import java.util.concurrent.CompletableFuture;

import com.google.common.base.Predicate;
import com.google.common.base.Supplier;

public class AsyncActionUntil {

  public static <T> CompletableFuture<T> repeat(Supplier<T> action, Predicate<T> until) {
    CompletableFuture<T> actionResult = CompletableFuture.supplyAsync(action);
    return actionResult.thenComposeAsync(r -> until.test(r) ? CompletableFuture.completedFuture(r): repeat(action, until));
  }
}
