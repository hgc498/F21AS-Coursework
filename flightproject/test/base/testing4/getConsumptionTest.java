package testing4;

import static org.junit.Assert.*;

import org.junit.Test;

import testing3.FlightTest;

public class getConsumptionTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		FlightPlanTest test = new FlightPlanTest();
		Double consumption = (double)58484848;
		Double output = test.getConsumption(consumption);
		assertEquals(consumption,output);
	}

}
