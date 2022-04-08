package testing2;

import static org.junit.Assert.*;

import org.junit.Test;

public class getLongitudeTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		AirportTest test = new AirportTest();
		Double longitude =(double) 1425;
		Double output = test.getLatitude(longitude);
		assertEquals(longitude,output);
	}

}
