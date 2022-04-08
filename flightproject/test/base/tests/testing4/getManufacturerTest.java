package testing4;

import static org.junit.Assert.*;

import org.junit.Test;

public class getManufacturerTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		FlightPlanTest test = new FlightPlanTest();
		String manufacturer = "Airbus";
		String output = test.getManufacturer(manufacturer);
		assertEquals(manufacturer,output);
	}

}
