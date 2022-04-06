package testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class getCodeTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		AirlineTest test = new AirlineTest();
		String code = "NW";
		String output = test.getName(code);
		assertEquals(code,output);
	}

}
