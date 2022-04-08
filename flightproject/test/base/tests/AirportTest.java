package base;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AirportTest {
	
	private Airport airport;

	@BeforeEach
	void setUp() throws Exception {
		airport = new Airport();
	}

	@Test
	void testGetSet() {
		airport.setCode("123");
		airport.setLatitude(12.5);
		airport.setLongitude(22.5);
		airport.setName("ccc");
		String code = airport.getCode();
		String name = airport.getName();
		Double latitude = airport.getLatitude();
		Double longitude = airport.getLongitude();
		
		assertEquals("123", code);
		assertEquals("ccc", name);
		String lat = "12.5";
		String lon = "22.5";
		String s1 = String.format("%.1f", longitude);
		String s2 = String.format("%.1f", latitude);
		assertEquals(s1, lon);
		assertEquals(s2, lat);
		
	}



	@Test
	void testInit() {
		String str = "AUH; Abu Dhabi;24°25'58.5408\"N; 54°38'40.3404\"E";
		boolean init = airport.init(str);
		assertTrue(init);
		String str1 = "Abu Dhabi;24°25'58.5408\"N; 54°38'40.3404\"E";
		boolean init1 = airport.init(str1);
		assertFalse(init1);
		
	}

	@Test
	void testToString() {
		String str = "AUH; Abu Dhabi;24°25'58.5408\"N; 54°38'40.3404\"E";
		airport.init(str);
		String str1 = "AUH;Abu Dhabi;24°25'58.54\";54°38'40.34\";";
		String string = airport.toString();
		assertEquals(string, str1);
	}

}
