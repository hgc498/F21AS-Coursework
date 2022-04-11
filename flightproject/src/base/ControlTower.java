package base;
import java.util.Queue;

public class ControlTower implements Runnable{
	
	//Flights notify the crossed tower about their new positions. 
	//The tower processes the information by retrieving it 
	//from the queue and storing it. 
	//The towers act as mediators between the GUI and the flights.

	//A thread communication mechanism must be implemented to allow
	//the GUI to get flights information from the towers and display it
  
  //needs linking with gui

	
	private String newPosition; 
	private Flight flight;
	private Queue<Flight> positions;
	private String status;
	

	public ControlTower(String newPosition, Boolean bool, Queue<Flight> positions) {
		// TODO Auto-generated method stub
		this.newPosition = newPosition; 
		this.positions = positions;
		//need to adjust if condition in thread manager 
		if (bool) {
			status = "arrived";
		}else {
			status = "departed";
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(!positions.isEmpty()) {
			
			try { 
				flight = positions.poll();
				System.out.println(" Flight " + flight.getCode() + " position is: " + newPosition);
				//Thread.sleep(500);
				if (status == "arrived") {
					Thread.sleep(1000);
				}else if (status == "departed") {
					Thread.sleep(2000);
				}
				
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			flight.FlightStats(status);
			System.out.println(" Flight "+ flight.getCode() + " has " + status);
			positions.add(flight);
			
		}
		
	}

}
