package system;

public class Checking_Account extends Account {
	protected double DebitLimit = -1000 ;
	private double balance ;
	


	
	public Checking_Account(int id , double balance ) throws LowBalanceException {
		super(id,balance,"EGP","Checking Account");
		this.balance=balance ;
		this.id=id ;
	}
	
	
	public double getDebitLimit() {
		return DebitLimit;
	}

	public void updateLimit (double debitLimit) {
		this.DebitLimit = debitLimit;
	}
	
	@Override
	public void deposit(double value) {
		balance += value ;
	}
	
	@Override
	public void withdraw(double value){
		LowBalanceException e = new LowBalanceException("you can't withdraw more than 1000 EGP as a debit value");
		if (balance - value >= this.DebitLimit){
            balance -= value ; 
         }
         else
         throw e;
	}
	
	public double addTheInterests() {
		double interests = (balance * 8 / 100.0);
		double interestsAddation = balance + interests;
		return interestsAddation;
	}
	
	@Override
	public void transfer(double transferValue, int personID) {
		LowBalanceException e = new LowBalanceException("you can't transfer more than 1000 EGP as a debit value");
		 if (balance - transferValue >= this.DebitLimit){
            this.withdraw(transferValue);
            Customer.Accounts.get(Bank_System.objNoFinder(personID)).deposit(transferValue);
          }
         else
    	     throw e; 
	}
	@Override
	public double Calc_balance() {
		balance=this.addTheInterests();
		return balance ;
	}

	@Override
	public String toString() {
		return  super.toString() + "\tDebit Limit : " + DebitLimit + "\n\tBalance After Adding Interests : " + this.addTheInterests()+"\n\n";
	}

}
