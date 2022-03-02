//class to contain airline details - names and codes 
public class Airline {
	
	private String name;
	private String code;
	
	//set up the airline details 
	public Airline(String name, String code) {
		
		if( name.trim().length() ==0|| code.trim().length()== 0)    
        {
          throw new IllegalStateException(
             "Cannot have blank airline or code");
        }
		if(code.trim().length() > 2) {
			throw new IllegalStateException("Please enter a valid airline code");
		}
		this.code = code.trim();
		this.name = name.trim();
		
	}
	
	public String getAirline() {
		return name;
	}
	
	public String getCode() {
		return code;
	}
	
	//comparing airlines by the code 
	public int comapreCodes(Airline otherCodes) {
		return code.compareTo(otherCodes.getCode());
	}
	
	// string containing all the details for the airline code and name 
	public String toString()
    {
        return String.format("%-5s", code ) + String.format("%-35s", name);
    }
	
}
