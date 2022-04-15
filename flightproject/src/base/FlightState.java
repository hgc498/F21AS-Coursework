package base;

public class FlightState {
	
	private Airport port;
	private int state;
	
	public FlightState(Airport port, int state) {
		super();
		this.port = port;
		this.state = state;
	}
	public Airport getPort() {
		return port;
	}
	public void setPort(Airport port) {
		this.port = port;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	

}
