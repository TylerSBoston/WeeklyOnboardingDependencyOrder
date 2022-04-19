
public class InvalidProjectException extends Exception{
	
	@Override
	public String getMessage() {
		return "Can't order unknown project";
	}
}
