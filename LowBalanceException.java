package system;

public class LowBalanceException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String alert ;
	public LowBalanceException() {
		super();
	}

	public LowBalanceException(String alert) {
		super(alert);
		this.alert = alert ;
	}
	
	public String getAlert () {
		return alert ;
	}

}
