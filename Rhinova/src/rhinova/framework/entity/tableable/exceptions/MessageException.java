package rhinova.framework.entity.tableable.exceptions;

public class MessageException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	
	String message = null;

	MessageException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public String toString() {
		return this.message;
	}
}
