package base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Flight implements Runnable {
public static String formatDateStr = "dd:MM:YYYY";
public static String formatTimeStr = "HH:mm";
public static String formatStr = "dd:MM:YYYY HH:mm";
	private String code;
	private String planCode;
	private String departure;
	private String destination;
	private Date begin;
	private List<String> towers = new ArrayList<>();
	private List<Airport> ports = new ArrayList<>();
	private FlightPlan plan = new FlightPlan();
	private String currentTower;
	private String nextTower;
	private int arrivalCount= 0;
	private int departureCount = 0;
	private String message;
	ControlTower target;
	Thread t;
	
	public String getCurrentTower() {
		return currentTower;
	}
	public void setCurrentTower(String currentTower) {
		this.currentTower = currentTower;
	}
	public String getNextTower() {
		return nextTower;
	}
	public void setNextTower(String nextTower) {
		this.nextTower = nextTower;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPlanCode() {
		return planCode;
	}
	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	public List<String> getTowers() {
		return towers;
	}
	public void setTowers(List<String> towers) {
		this.towers = towers;
	}
	
	public String getDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
		return format.format(begin);
	}
	public String getTimeStr() {
		SimpleDateFormat format = new SimpleDateFormat(formatTimeStr);
		return format.format(begin);
	}
	
	public List<Airport> getPorts() {
		return ports;
	}
	public void setPorts(List<Airport> ports) {
		this.ports = ports;
	}
	public FlightPlan getPlan() {
		return plan;
	}
	public void setPlan(FlightPlan plan) {
		this.plan = plan;
	}
	public Flight() {
		
	}
	
	public boolean init(String line) {
		if (line == null || line.trim().equals("")) {
			return false;
		}
		String[] split = line.split(";");
		if (split.length < 7) {
			return false;
		}
		this.code = split[0].trim(); 
		this.planCode = split[1].trim(); 
		this.departure = split[2].trim(); 
		this.destination = split[3].trim();
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		try {
			this.begin = format.parse(split[4].trim()+" "+split[5].trim());
		} catch (ParseException e) {
			return false;
		}
		
		for (int i = 6; i < split.length; i++) {
			String str = split[i];
			if (str == null || str.trim().equals("") ) {
				continue;
				
			}
			str = str.trim();
			towers.add(str);
		}
		return true;
	}
	
	public void addAirport(Airport port) {
		this.ports.add(port);
	}
	
	
	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat(formatDateStr);
		SimpleDateFormat format1 = new SimpleDateFormat(formatTimeStr);
		StringBuffer sb = new StringBuffer();
		sb.append(code).append(";")
			.append(planCode).append(";")
			.append(departure).append(";")
			.append(destination).append(";")
			.append(format.format(begin)).append(";")
			.append(format1.format(begin)).append(";");
		for (String string : towers) {
			sb.append(string).append(";");
		}
		return sb.toString();
	}
	
	public void fly() {
		
		
	}
	public void FlightStats(String status) {
		// TODO Auto-generated method stub
		if (status.equals("arrived")) {
			arrivalCount++;
		} else {
			departureCount++;
		}
		
	}
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
