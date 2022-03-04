package testing4;

import static org.junit.Assert.*;

import org.junit.Test;

public class getModelTest {

	@Test
	public void test() {
	//	fail("Not yet implemented");
		FlightPlanTest test = new FlightPlanTest();
		String model = "A330";
		String output = test.getModel(model);
		assertEquals(model,output);
	}

}
