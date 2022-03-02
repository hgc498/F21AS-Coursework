//maintains airlines in an arraylist

import java.util.ArrayList;

public class AirlineList {
	
	
	private ArrayList<Airline> airlineList;
	
	public AirlineList() {
		
		airlineList = new ArrayList<Airline>();
		
	}
	//look at the code and return the airline
	public Airline findByCode(String code) {
		for (Airline a : airlineList) {
			if(a.getCode().equals(code)) {
				return a;
			}
		}
		return null;
	}
	//look at the name and return the airline
	public Airline findByName(String name) {
		for (Airline a : airlineList) {
			if(a.getAirline().equals(name)) {
				return a;
			}	
		}
		return null;
	}
	// add airline, checking the code and the name of the airline
	public void addAirline(Airline airline)throws DuplicateIDException{
		
		if (airline == null)
			throw new IllegalArgumentException();
		else {
			String code = airline.getCode();
			String name = airline.getAirline();
			if(findByCode(code) != null && findByName(name) != null)
				throw new DuplicateIDException(code);
			else
				airlineList.add(airline);
		}
	}
	// remove an airline, checking the code 
	public void removeAirline(String code) throws NoMatchingIDException{
		int index = findIndex(code);
		if(index != -1) {
			airlineList.remove(index);
		}else
			throw new NoMatchingIDException(code);
		return;
	}
	
	//find the code 
	private int findIndex(String code) {
		int size = airlineList.size();
		for (int i = 0; i < size; i++) {
			Airline a = airlineList.get(i);
			if(a.getCode().equals(code)) {
				return i;
			}
		}
		return -1;
	}
	
	

}
