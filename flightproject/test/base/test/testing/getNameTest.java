package testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class getNameTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		
		AirlineTest test = new AirlineTest();
		String name = "American Airlines";
		String output = test.getName(name);
		assertEquals(name,output);
		
	}

}
