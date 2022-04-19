
public class InvalidOrderException extends Exception{
	
	@Override
	public String getMessage() {
		return "No Valid Boot Order";
	}
}