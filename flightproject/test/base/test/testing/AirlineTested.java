package testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class AirlineTested {

	@Test
	public void test() {
		//fail("Not yet implemented");
		AirlineTest test = new AirlineTest();
		String line = "NW; Northwest Airlines ";
		String output = test.getName(line);
		assertEquals(line,output);
	}

}
