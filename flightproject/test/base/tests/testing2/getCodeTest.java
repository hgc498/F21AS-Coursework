package testing2;

import static org.junit.Assert.*;

import org.junit.Test;



public class getCodeTest {

	@Test
	public void test() {
	//	fail("Not yet implemented");
		AirportTest test = new AirportTest();
		String code = "JED";
		String output = test.getName(code);
		assertEquals(code,output);
		
	}

}
