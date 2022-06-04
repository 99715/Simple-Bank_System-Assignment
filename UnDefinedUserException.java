package system;

public class UnDefinedUserException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String alert ;
	public UnDefinedUserException() {
		super();
	}

	public UnDefinedUserException(String alert) {
		super(alert);
		this.alert = alert ;
	}
	
	public String getAlert () {
		return alert ;
	}

}
