package system;

public class Saving_Account extends Account {
	protected double interestsRate = 8.0 ; 
	private double interests ;
	private double balance ;
	
	public Saving_Account() {
		super();
	}
	
	public Saving_Account(int id , double balance ) throws LowBalanceException {
		super(id,balance,"EGP","Saving Account");
		this.balance = balance;
		this.id=id;
	}
	
	public double getInterestsRate() {
		return interestsRate;
	}

	public void updateInterestRate(double interestsRate) {
		this.interestsRate = interestsRate;
	}

	public double getInterests() {
		return (balance * interestsRate / 100.0);
	}

	public void setInterests(double interests) {
		this.interests = interests;
	}
	
	public double addTheInterests() {
		interests = (balance * interestsRate / 100.0);
		double interestsAddation = balance + interests;
		return interestsAddation;
	}

	@Override
	public double Calc_balance() {
		balance=this.addTheInterests();
		return balance;
	}
	
	@Override
	public String toString() {
		return super.toString()+"\tInterests Rate=" + interestsRate + "\n\tYour Interests : " + this.getInterests() + "\n\tBalance After Adding Interests : " + this.addTheInterests()+"\n\n";
	}
	

}
