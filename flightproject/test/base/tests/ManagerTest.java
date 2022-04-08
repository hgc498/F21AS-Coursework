package base;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagerTest {
	
	private Manager manager;

	@BeforeEach
	void setUp() throws Exception {
		manager = new Manager();
	}

	@Test
	void testLoadAll() {
		manager.loadAll();
		List<Airline> airlines = manager.getAirlines();
		List<Airport> airports = manager.getAirports();
		List<FlightPlan> plans = manager.getPlans();
		List<Flight> flights = manager.getFlights();
		assertNotEquals((Integer)0, (Integer)airlines.size());
		assertNotEquals((Integer)0, (Integer)airports.size());
		assertNotEquals((Integer)0, (Integer)plans.size());
		assertNotEquals((Integer)0, (Integer)flights.size());
	}


	

	@Test
	void testFindFlightByCode() {
		manager.loadAll();
		Flight findFlightByCode = manager.findFlightByCode("AF670");
		assertNotNull(findFlightByCode);
		Flight findFlightByCode2 = manager.findFlightByCode("AF6701");
		assertNull(findFlightByCode2);
	}

	@Test
	void testFindPlanByCode() {
		manager.loadAll();
		FlightPlan findPlanByCode = manager.findPlanByCode("B777");
		assertNotNull(findPlanByCode);
		FlightPlan findPlanByCode2 = manager.findPlanByCode("B6777");
		assertNull(findPlanByCode2);
	}

	@Test
	void testFindPortByCode() {
		manager.loadAll();
		Airport findPortByCode = manager.findPortByCode("LHR");
		Airport findPortByCode2 = manager.findPortByCode("LHR1");
		assertNotNull(findPortByCode);
		assertNull(findPortByCode2);
	}

	@Test
	void testAddFlight() {
		manager.loadAll();
		Integer size = manager.getFlights().size();
		Flight flight = new Flight();
		String str = "BA534; B777; LHR; SFO; 12:01:2022; 14:00; LHR; MIA; SFO";
		flight.init(str);
		manager.addFlight(flight);
		Integer size2 = manager.getFlights().size();
		assertEquals(size, (Integer)(size2-1));
	}

}
