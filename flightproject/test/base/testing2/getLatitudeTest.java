package testing2;

import static org.junit.Assert.*;

import org.junit.Test;

import testing.AirlineTest;

public class getLatitudeTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		AirportTest test = new AirportTest();
		Double latitude =(double) 1425;
		Double output = test.getLatitude(latitude);
		assertEquals(latitude,output);
	}

}
