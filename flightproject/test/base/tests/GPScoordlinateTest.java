package base;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import util.DistanceUtils;

class GPScoordlinateTest {
	
	private GPScoordlinate gps;

	@BeforeEach
	void setUp() throws Exception {
		gps = new GPScoordlinate();
	}

	@Test
	void testGetDistance() {
		Manager manager = new Manager();
		manager.loadAll();
		List<Airport> airports = manager.getAirports();
		Airport a1 = airports.get(0);
		Airport a2 = airports.get(1);
		Double distance = DistanceUtils.getDistance(a1.getLongitude(), a1.getLatitude(), a2.getLongitude(), a2.getLatitude());
		Double distance2 = gps.getDistance(a1, a2);
		assertEquals(distance.intValue(), distance2.intValue());
		
	}

}
