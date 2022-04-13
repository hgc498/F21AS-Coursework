// FlightThread.java
//Created by implementing Runnable interface
//and using synchronization

class ControlTower {
	synchronized void permission(String message) {
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
//create the flight thread
class Flight implements Runnable{
	String message;
	ControlTower target;
	Thread t;
//instantiate and call thread object
public Flight(ControlTower targ, String s){
	target=targ;
	message=s;
	t=new Thread(this); 
	t.start(); 
    }
//synchronize flight with tower
public void run(){
	synchronized(target){
	target.permission(message);
	}
    }
}
//main program 
class FlightThread{
	public static void main(String [] args){
	ControlTower target=new ControlTower();
	Flight flight1= new Flight(target, "Flight 1");
	Flight flight2= new Flight(target, "Flight 2");
	Flight flight3= new Flight(target, "Flight 3");
	Flight flight4= new Flight(target, "Flight 4");
	try{
		flight1.t.join();
		flight2.t.join();
		flight3.t.join();
		flight4.t.join();
	   }
	//throwing an exception
	catch(InterruptedException e){
		System.out.println("Process was Interrupted");
	}
    }
}
