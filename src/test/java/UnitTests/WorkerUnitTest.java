package UnitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import skTest.Aggregator;
import skTest.Worker;

public class WorkerUnitTest {

	@Before
	public void setUp() throws Exception {
		Aggregator.reset();
	}

	@Test
	public void test() {
		String [] line = { "1", "2", "3" };		
		Worker w = new Worker(line);
		w.start();		
		try {
			w.join();
			int rows = Aggregator.publishWork();	
			assertTrue(rows == 1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
