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
		BlockingQueue<Flight> positions = new ArrayBlockingQueue<Flight>(3);
		
		//set up the threads 
		//tower threads 
		ControlTower t1 = new ControlTower(newPosition, rand.nextBoolean(), positions);
		ControlTower t2 = new ControlTower(newPosition,rand.nextBoolean() , positions);
		//flight threads 
		
		//start the threads 
		new Thread(t1).start();
		new Thread(t2).start();
		
		
		//to do 
		for(int i = 1; i <= 3; i++) {
			positions.add(new Flight());
		}
		
		
	}

}
