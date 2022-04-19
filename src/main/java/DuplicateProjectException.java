
public class DuplicateProjectException extends Exception{
	
	@Override
	public String getMessage() {
		return "duplicate projects";
	}
}