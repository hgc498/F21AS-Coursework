
public class NoMatchingIDException extends Exception{
	
	public NoMatchingIDException(String code){
		super("No such code = " + code);
	}

}
