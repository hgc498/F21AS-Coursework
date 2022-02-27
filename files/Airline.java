//class to contain airline details - names and codes 
public class Airline {
	
	private String name;
	private String code;
	
	
	public Airline(String name, String code) {
		
		if( name.trim().length() ==0|| code.trim().length()== 0)    
        {
          throw new IllegalStateException(
             "Cannot have blank airline or code");
        }
		if(code.trim().length() > 2) {
			throw new IllegalStateException("Please enter a valid airline code");
		}
		
	}
	
	public String getAirline() {
		return name;
	}
	
	public String getCode() {
		return code;
	}
	
}
