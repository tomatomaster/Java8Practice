package ch01.ex9;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface Collection2<E> extends Collection<E> {

  /**
   * コレクション要素が特定の状態を持つ場合に対して修正を加えたいが、
   * そのような状態を持つ値が修正不可能な第三者から渡される場合にfilterでフィルタリングを行い、
   * actionで修正を行うことができる。
   * 
   * @param action
   * @param filter
   */
  public default void forEachIf(Consumer<E> action, Predicate<E> filter) {
    while(iterator().hasNext()) {
      E element = iterator().next();
      if(filter.test(element)) {
        action.accept(element);
      }
    }
  }
}
