package testing2;

import static org.junit.Assert.*;

import org.junit.Test;

public class AirportTested {

	@Test
	public void test() {
		//fail("Not yet implemented");
		AirportTest test = new AirportTest();
		String line = "JED; Jeddah; 21°40'27.59\" N; 39°09'14.40\" E; ";
		String output = test.getName(line);
		assertEquals(line,output);
	}

}
