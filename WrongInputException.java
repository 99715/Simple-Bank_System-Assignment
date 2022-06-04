package system;

public class WrongInputException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String alert ;
	public WrongInputException() {
		super();
	}

	public WrongInputException(String alert) {
		super(alert);
		this.alert = alert ;
	}
	
	public String getAlert () {
		return alert ;
	}


}
