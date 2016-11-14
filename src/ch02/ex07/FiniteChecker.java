package ch02.ex07;

import java.util.stream.Stream;

/**
 * 終端処理でストリームが閉じてしまうため、
 * 無限ストリームのチェック終了後ストリーム操作ができなくなるので、上司の指示はあまり意味をなさない。
 * 
 * closedunbounded.hatenablog.com/entry/2015/01/20/131906
 */
public class FiniteChecker {

  public static <T> boolean isFinite(Stream<T> stream) {
    if(stream.spliterator().estimateSize() == Long.MAX_VALUE) {
      return false;
    }
      return true;
  }
}
