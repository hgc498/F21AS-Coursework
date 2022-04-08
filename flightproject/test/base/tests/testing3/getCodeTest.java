package testing3;

import static org.junit.Assert.*;

import org.junit.Test;

import testing2.AirportTest;

public class getCodeTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		FlightTest test = new FlightTest();
		String code = "AF670";
		String output = test.getCode(code);
		assertEquals(code,output);
	}

}
