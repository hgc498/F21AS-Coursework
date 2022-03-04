package exceptions;

public class NoMatchException extends Exception{
	
	public NoMatchException(String match){
		super("Entry does not match = " + match);
	}

}
