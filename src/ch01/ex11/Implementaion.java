package ch01.ex11;

/**
 * スーパークラスSのメソッドfの可視性がpublicでないならば、コンパイルが失敗する。
 * fはインタフェースで宣言されているため、publicである必要がある。
 * 
 * 同一シグニチャを持つデフォルトメソッドを有するインタフェースを複数implementsすると、
 * どちらの実装を使用するべきか判断がつかないためコンパイル不可
 * 
 * staticメソッドは{Interface}.{StaticMethod}で一意に特定可能なため、
 * コンパイル可能
 * 
 * abstractは実装されていれば問題ない
 * 
 * @author ono
 *
 */
public class Implementaion extends S implements I, J {
  
  public void test() {
    I.staticMethod();
    J.staticMethod();
  }

  @Override
  public void abstractMethod() {
    System.out.println("abstract");
  }

}
