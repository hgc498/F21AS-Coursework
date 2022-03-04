package base;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AirlineTest {
	
	private Airline line;

	@BeforeEach
	void setUp() throws Exception {
		line = new Airline();
	}

	@Test
	void testSetGet() {
		line.setCode("123");
		line.setName("bbb");
		String code = line.getCode();
		String name = line.getName();
		assertEquals("123", code);
		assertEquals("bbb", name);
	}


	@Test
	void testInit() {
		String str = "FX; Fedex";
		boolean init = line.init(str);
		assertTrue(init);
		String str1 = "dd";
		boolean init2 = line.init(str1);
		assertFalse(init2);
	}

	@Test
	void testToString() {
		String str = "FX; Fedex";
		line.init(str);
		String string = line.toString();
		String str1 = "FX;Fedex";
		assertEquals(str1, string);
	}

}
