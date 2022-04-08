package testing3;

import static org.junit.Assert.*;

import org.junit.Test;

public class getPlanCodeTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		FlightTest test = new FlightTest();
		String plancode = "DBX";
		String output = test.getPlanCode(plancode);
		assertEquals(plancode,output);
	}
	}


