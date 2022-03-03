public class InvalidCoordinateException extends Exception {

	public InvalidCoordinateException(){
		super("GPScoordinate cannot be retrieved");
	}
	public InvalidCoordinateException (String message) {
		super (message);
	}
}
