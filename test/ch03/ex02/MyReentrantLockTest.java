package ch03.ex02;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class MyReentrantLockTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	Runnable run;

	@Before
	public void setUp() throws Exception {
		run = () -> {
			MyReentrantLock lock = new MyReentrantLock();
			lock.withLock(lock, () -> {
				increment();
			});
		};
	}

	@Test
	public void ロックが解除されてから処理を行う() {
		for (int i = 0; i < 49; i++) {
			new Thread(run).start();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {}
		}
		assertThat(increment(), is(50));
	}

	@Test
	public void ほぼ同時に処理を行わせることで一部の処理をロックさせる() {
		for (int i = 0; i < 49; i++) {
			new Thread(run).start();
		}
		assertThat(increment(), not(50));
	}

	int i = 0;

	private int increment() {
		return ++i;
	}

}
