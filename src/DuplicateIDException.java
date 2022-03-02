
public class DuplicateIDException extends Exception {

	public DuplicateIDException(String dupAirline){
		super("Duplicate airline = " + dupAirline);
	}
}
