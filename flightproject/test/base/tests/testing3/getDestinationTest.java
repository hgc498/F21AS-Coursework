package testing3;

import static org.junit.Assert.*;

import org.junit.Test;

public class getDestinationTest {

	@Test
	public void test() {
	//	fail("Not yet implemented");
		FlightTest test = new FlightTest();
		String destination = "DBX";
		String output = test.getDestination(destination);
		assertEquals(destination,output);
	}

}
