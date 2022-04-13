package base;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadManager {
	
	
	public static void main(String[] args) {
		
		
		String newPosition = null;
		Random rand = new Random();
		
		// create blocking queue to store positions of flights
		//
		BlockingQueue<Flight> positions = new ArrayBlockingQueue<Flight>(4);
		
		//set up the control tower threads 
		ControlTower t1 = new ControlTower(newPosition, rand.nextBoolean(), positions);
		ControlTower t2 = new ControlTower(newPosition,rand.nextBoolean() , positions);
		
		//start the threads 
		new Thread(t1).start();
		new Thread(t2).start();
		
		
		//set up the flight threads 
		Flight flight1= new Flight(t1, "Flight 1");
		Flight flight2= new Flight(t1, "Flight 2");
		Flight flight3= new Flight(t2, "Flight 3");
		Flight flight4= new Flight(t2, "Flight 4");
		
		try{
			flight1.t.join();;
			flight2.t.join();
			flight3.t.join();
			flight4.t.join();
			
			
		   }
		//throwing an exception
		catch(InterruptedException e){
			System.out.println("Process was Interrupted");
		}
		
		
		
		
		for(int i = 1; i <= 4; i++) {
			positions.add(new Flight());
		}
		
		
	}

}
