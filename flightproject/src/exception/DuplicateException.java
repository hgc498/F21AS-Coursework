package exceptions;

public class DuplicateException extends Exception {

	public DuplicateException(String dup){
		super("Duplicate entry = " + dup);
	}
}
