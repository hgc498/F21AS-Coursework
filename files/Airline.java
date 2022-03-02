//class to contain airline details - names and codes 
public class Airline {
	
	private String code;
	private String name;
	
	public Airline(String name, String code) {
	//if no details have been entered for either the code or the name, throw an illegal exception	
		if( name.trim().length() ==0|| code.trim().length()== 0)    
        {
          throw new IllegalStateException(
             "Cannot have blank airline or code");
        }
		if(code.trim().length() > 2) {
			throw new IllegalStateException("Please enter a valid airline code");
		}
		
	}
	public String getCode() {
		return code;
	}
	
	public String getAirline() {
		return name;
	}
	
	//String containing all the details of airlines 
	public String toString()
    	{
        return String.format("%-5s", code ) + String.format("%-35s", name);
    	}
	
}
