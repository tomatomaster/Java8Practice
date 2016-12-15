package ch03.ex19;

/**
 * A:? extends Uと置き換えても、accumulatorにはUの型で処理される
 * 
 * <U> U reduce(U identity,
 *            BiFunction<U,? super T,U> accumulator,
 *            BinaryOperator<U> combiner)
 * 指定された単位元、累積関数、および結合的関数を使用して、このストリームの要素に対してリダクションを実行します。これは、次の操作に相当します。
 *
 * U result = identity;
 * for (T element : this stream)
 *   result = accumulator.apply(result, element)
 * return result;
 * 
 */
public class Reduce {

}
