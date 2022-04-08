package base;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FlightTest {
	
	private Flight flight;

	@BeforeEach
	void setUp() throws Exception {
		flight = new Flight();
	}

	@Test
	void testSetGet() {
		List<String> towers = new ArrayList<>();
		towers.add("a");
		towers.add("b");
		towers.add("c");
		flight.setCode("123");
		flight.setDeparture("aaa");
		flight.setDestination("bbb");
		flight.setPlanCode("ddd");
		flight.setTowers(towers);
		String str = "2022-12-12 06:33";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date parse = null;
		try {
			parse = format.parse(str);
			flight.setBegin(parse);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String code = flight.getCode();
		String planCode = flight.getPlanCode();
		String departure = flight.getDeparture();
		String destination = flight.getDestination();
		String dateStr = flight.getDateStr();
		String timeStr = flight.getTimeStr();
		List<String> towers2 = flight.getTowers();
		assertEquals("123", code);
		assertEquals("ddd", planCode);
		assertEquals("aaa", departure);
		assertEquals("bbb", destination);
		assertEquals("12/12/2022", dateStr);
		assertEquals("06:33", timeStr);
		assertEquals(towers2, towers);
		
	}


	@Test
	void testInit() {
		String str = "BA534; B777; LHR; SFO; 12:01:2022; 14:00; LHR; MIA; SFO";
		boolean init = flight.init(str);
		assertTrue(init);
		str = "BA534; B777; LHR; SFO; 12:01:2022; 14:00";
		boolean init2 = flight.init(str);
		assertFalse(init2);
	}

	@Test
	void testToString() {
		String str = "BA534; B777; LHR; SFO; 12:01:2022; 14:00; LHR; MIA; SFO";
		flight.init(str);
		String str1 = "BA534;B777;LHR;SFO;26:12:2022;14:00;LHR;MIA;SFO;";
		String string = flight.toString();
		assertEquals(string, str1);
	}

}
