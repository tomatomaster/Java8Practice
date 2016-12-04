package ch03.ex03;

/**
 * 実行時にアサーションを無効にした場合、余計なメモリを消費することを防ぐため。
 * 
 * A:ライブラリとして実装できない。<br>
 * ライブラリの機能として実装した場合、assertメソッドを何らかの方法で無効にした場合
 * 条件式を評価する必要はないが、無効であるということを評価しなくてはならず、
 * 完全にパフォーマンスに対する影響がなくなるとは言えないのでライブラリとして実装できない。
 * 
 * <p>
 * アサーションを無効にすると、パフォーマンスに対する影響が完全になくなります。無効になったアサーションは、セマンティクスおよびパフォーマンスの観点から見ると、基本的に空文と同じです。
 * {@link https://docs.oracle.com/javase/jp/6/technotes/guides/language/assert.html#enable-disable}
 */
public class Assertion {

  public static void main(String[] args) {
    assert false : "Trouble happen here, not meeting.";
    assert true;
  }
}
