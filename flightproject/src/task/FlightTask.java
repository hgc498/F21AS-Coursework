package task;

import java.util.ArrayList;
import java.util.List;

import base.Airport;
import base.Flight;
import base.FlightState;
import base.GPScoordlinate;
import window.MainWindow;

public class FlightTask implements Runnable{
	
	private Flight flight;
	private int runningTime;
	private Double totalDis;
	private List<FlightState> states = new ArrayList<>();
	private GPScoordlinate gps = new GPScoordlinate();
	public FlightTask(Flight flight) {
		this.flight = flight;
		this.runningTime = 0;
		List<Airport> ports = this.flight.getPorts();
		for (Airport airport : ports) {
			states.add(new FlightState(airport,0));
		}
		states.get(0).setState(1);
		totalDis = gps.getDistance(flight.getPorts().get(0), flight.getPorts().get(flight.getPorts().size()-1));
	}
	@Override
	public void run() {
		Double current = (runningTime/60)*flight.getPlan().getSpeed();
		freshState(current);
		if (current >= totalDis) {
			return;
		}
		runningTime = runningTime + 1;
	}
	
	private void freshState(Double current) {
		for (int i = 1; i < states.size(); i++) {
			if (states.get(i).getState() == 0) {
				Double distance = gps.getDistance(flight.getPorts().get(0), states.get(i).getPort());
				if (distance <= current) {
					states.get(i).setState(1);
					MainWindow.logger.log(flight.getCode() +" arrived at "+ states.get(i).getPort().getCode());
				}
				break;
			}
		}
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public List<FlightState> getStates() {
		return states;
	}
	public void setStates(List<FlightState> states) {
		this.states = states;
	}
	
	public Airport getCurrent() {
		for (int i = 1; i < states.size() ; i++) {
			FlightState flightState = states.get(i);
			if (flightState.getState() == 0 && states.get(i-1).getState() == 1) {
				return states.get(i-1).getPort();
			}
		}
		return null;
	}
	
	public Airport getNext() {
		for (int i = 1; i < states.size() ; i++) {
			FlightState flightState = states.get(i);
			if (flightState.getState() == 0 && states.get(i-1).getState() == 1) {
				return flightState.getPort();
			}
		}
		return null;
	}
}
