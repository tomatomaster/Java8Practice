package ch06.ex11;

import java.net.PasswordAuthentication;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class Rpeater {

	PasswordAuthentication authentication;
	
	public static void main(String[] args) {

	}
	
	public static <T> CompletableFuture<T> repeat(Supplier<T> action, Predicate<T> until) {
		T actionValue;
		do {
			actionValue = action.get();	
		} while(!until.test(actionValue));
		return new CompletableFuture<T>().;
	}
}
