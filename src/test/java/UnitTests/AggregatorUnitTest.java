package UnitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import skTest.Aggregator;

public class AggregatorUnitTest {

	@Before
	public void setUp() throws Exception {
		Aggregator.reset();
	}

	@Test
	public void test() {
		int rows = Aggregator.recordWork();
		assertTrue(rows == 1);
		rows = Aggregator.recordWork();
		assertTrue(rows == 2);
	}

}
