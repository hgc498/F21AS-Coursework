public class InvalidLocationException extends Exception {

	public InvalidLocationException(){
		super("Location information could not be found");
	}
	public InvalidLocationException (String message) {
		super (message);
	}
}
