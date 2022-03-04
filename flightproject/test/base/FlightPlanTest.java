package base;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FlightPlanTest {
	
	private FlightPlan plan ;

	@BeforeEach
	void setUp() throws Exception {
		plan = new FlightPlan();
	}

	@Test
	void testSetGet() {
		plan.setModel("1");
		plan.setManufacturer("333");
		plan.setSpeed(12.55);
		plan.setConsumption(1245.63);
		String model = plan.getModel();
		String manufacturer = plan.getManufacturer();
		Double speed = plan.getSpeed();
		Double consumption = plan.getConsumption();
		String speedStr = "12.55";
		String conStr = "1245.63";
		String s1 = String.format("%.2f", speed);
		String s2 = String.format("%.2f", consumption);
		assertEquals(s1, speedStr);
		assertEquals(s2, conStr);
		assertEquals("333",	 manufacturer);
		assertEquals("1",	 model);
	}

	@Test
	void testInit() {
		String str = "CRJ100; Bombardier; 730; 1200";
		boolean init = plan.init(str);
		assertTrue(init);
		str = "CRJ100; Bombardier; 730";
		boolean init2 = plan.init(str);
		assertFalse(init2);
		
	}

	@Test
	void testToString() {
		String str = "CRJ100; Bombardier; 730; 1200";
		plan.init(str);
		String str1 = "CRJ100;Bombardier;730.0;1200.0";
		String string = plan.toString();
		assertEquals(str1, string);
	}

}
