package ch01.ex08;

import java.util.ArrayList;
import java.util.List;

/**
 *　A 各ラムダ式は異なる値をキャプチャする
 * 
 * */
public class Capture {
  public static void main(String[] args) {
    String[] 名前の配列 = {"paul", "merry", "tom"};
    List<Runnable> らんなぁ = new ArrayList<Runnable>();
    //拡張for文
    for(String 名前 : 名前の配列)
      らんなぁ.add(()->{
        System.out.println(名前);
      });
    for(Runnable 藍嬲流 : らんなぁ)
      藍嬲流.run();
    //for文
    らんなぁ.clear();
    for (int i = 0; i < 名前の配列.length; i++) {
      String lName = 名前の配列[i];
      らんなぁ.add(()->{
        System.out.println(lName);
      });
    }
    for(Runnable run : らんなぁ)
      run.run();
  }
}
