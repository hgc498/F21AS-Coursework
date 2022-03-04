package base;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import util.FileUtils;

public class Manager {

	private static final String AIRPORT_FILE = "airports.txt";
	private static final String AIRLINE_FILE = "airlines.txt";
	private static final String FLIGHT_FILE = "flights.txt";
	private static final String PLANE_FILE = "planes.txt";

	private List<Airport> airports = new ArrayList<>();
	private List<Airline> airlines = new ArrayList<>();
	private List<Flight> flights = new ArrayList<>();
	private List<FlightPlan> plans = new ArrayList<>();

	public Manager() {

	}

	public void loadAll() {
		loadAirports();
		loadAirlines();
		loadFlights();
		loadPlanes();
	}

	private void loadAirports() {
		List<String> readLines = FileUtils.readLines(getFile(AIRPORT_FILE));
		for (String string : readLines) {
			Airport airport = new Airport();
			if (!airport.init(string)) {
				continue;
			}
			airports.add(airport);
		}

	}

	private void loadAirlines() {
		List<String> readLines = FileUtils.readLines(getFile(AIRLINE_FILE));
		for (String string : readLines) {
			Airline airline = new Airline();
			if (!airline.init(string)) {
				continue;
			}
			airlines.add(airline);
		}
	}

	private void loadFlights() {
		List<String> readLines = FileUtils.readLines(getFile(FLIGHT_FILE));
		for (String string : readLines) {
			Flight flight = new Flight();
			if (!flight.init(string)) {
				continue;
			}
			flights.add(flight);
		}
	}

	private void loadPlanes() {
		List<String> readLines = FileUtils.readLines(getFile(PLANE_FILE));
		for (String string : readLines) {
			FlightPlan flightPlan = new FlightPlan();
			if (!flightPlan.init(string)) {
				continue;

			}
			plans.add(flightPlan);
		}

	}

//	public void saveAirports() {
//		FileUtils.writeFile(getList(airports,Airport.class), getFile(AIRPORT_FILE));
//		
//	}
//	public void saveAirlines() {
//		FileUtils.writeFile(getList(airlines,Airline.class), getFile(AIRLINE_FILE));
//		
//	}
	private void saveFlights() {
		FileUtils.writeFile(getList(flights, Flight.class), getFile(FLIGHT_FILE));

	}
//	public void savePlanes() {
//		FileUtils.writeFile(getList(plans,FlightPlan.class), getFile(PLANE_FILE));
//		
//	}

	private static File getFile(String fileName) {
		try {
			File file = new File(Manager.class.getClassLoader().getResource(fileName).toURI());
			return file;
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static <T> List<String> getList(List<T> objs, Class<T> clazz) {
		List<String> list = new ArrayList<>();
		for (Object obj : objs) {
			list.add(obj.toString());
		}
		return list;
	}

	public List<Airport> getAirports() {
		return airports;
	}

	public List<Airline> getAirlines() {
		return airlines;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public List<FlightPlan> getPlans() {
		return plans;
	}

	public Flight findFlightByCode(String code) {
		for (Flight flight : flights) {
			if (flight.getCode().equals(code)) {
				return flight;
			}
		}
		return null;
	}

	public FlightPlan findPlanByCode(String planCode) {
		for (FlightPlan flight : plans) {
			if (flight.getModel().equals(planCode)) {
				return flight;
			}
		}
		return null;
	}

	public Airport findPortByCode(String code) {
		for (Airport flight : airports) {
			if (flight.getCode().equals(code)) {
				return flight;
			}
		}
		return null;
	}

	public boolean addFlight(Flight flight) {
		boolean add = flights.add(flight);
		saveFlights();
		return add;
	}

}
