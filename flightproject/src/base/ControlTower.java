package base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import task.FlightTask;
import window.MainWindow;

public class ControlTower implements Runnable{
	private List<Flight> flights = new ArrayList<>();
	
	private ScheduledExecutorService pool ;
	
	private List<FlightTask> tasks = new ArrayList<>();
	
	private BlockingQueue<Flight> positions;
	boolean isRunning;
	private String status;
	
	public ControlTower() {
		pool = (ScheduledExecutorService) Executors.newScheduledThreadPool(300);
		
		if (isRunning = true) {
			status = "arrived";
		}else {
			status = "departed";
		}
	}
	
	public void removeFlight(String code) {
		int index = -1;
		for (int i = 0; i < flights.size(); i++) {
			if (flights.get(i).getCode().equals(code)) {
				index = i;
				break;
			}
		}
		if (index != -1) {
			flights.remove(index);
		}
	}
	
	public void addFlight(Flight item) {
		flights.add(item);
	}
	
	public void run() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (Flight flight : flights) {
					FlightTask task = new FlightTask(flight);
					tasks.add(task);
					pool.scheduleAtFixedRate(task, 1, 3, TimeUnit.SECONDS);
					MainWindow.logger.log(flight.getCode()+" is start.");
					while(isRunning == true) {
					try { 
					if (status == "arrived") {
						Thread.sleep(1000);
					}else if (status == "departed") {
						Thread.sleep(2000);
					}}catch (InterruptedException e) {
						e.printStackTrace();
					}
					flight.FlightStats(status);
					System.out.println(" Flight "+ flight.getCode() + " has " + status);
				}
				}
				
			}
		}).start();
	}

	public FlightTask findFlightByCode(String code) {
		for (FlightTask task : tasks) {
			String code2 = task.getFlight().getCode();
			if (code.equals(code2)) {
				return task;
			}
		}
		return null;
	}
	synchronized void permission(String message) {
		// TODO Auto-generated method stub
		System.out.print(" " + message);
		try {
		    //waiting for one second
		    Thread.sleep(1000);
		    }
		catch(InterruptedException e){
		    //throwing an exception
	            System.out.println("Process was Interrupted");
		}
		    System.out.println(" ");
	 }
		
	
	

}
