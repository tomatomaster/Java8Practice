package ch03.ex01;

import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;


public class ConditionalLoggerTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testLogIf() {
		
		Logger logger = ConditionalLogger.getLogger(ConditionalLogger.class.getName());
		int result = 1 + 1; 
		logger.logIf(Logger.getGlobal().getLevel().FINE, ()-> {return result > 1 ? true : false ;}, () -> "Log");
	}

}
