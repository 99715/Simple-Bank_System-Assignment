package system;


public abstract class Account {
	protected double balance  ;
    protected String currency = "EGP" ;
    protected String account_type ;
    protected int id ;
    LowBalanceException e = new LowBalanceException("\n\t\t\t\tBalance less than 1000 EGP will not be allowed\n");
    public Account() {
		super();
		Customer.Accounts.add(this);
	}

	public Account(int id , double balance, String currency , String account_type) {
		if(balance>=1000){
			this.balance = balance;
			
		}
		else {
		   throw e;
		}
		this.currency = currency;
		this.account_type = account_type;
		this.id = id;
		Customer.objArrNo = Bank_System.person.size();
		Customer.Accounts.add(this);
	}


	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void withdraw (double value){
		LowBalanceException e = new LowBalanceException( "Current balance "+ balance + " " + currency + "is less than withdraw value " + value + " " + currency);
		if (balance >= value) { 
			balance -= value;
		     }
		else
			throw e;
    }
    
    public void deposit (double value){
    	IllegalArgumentException e =new IllegalArgumentException("Invalid deposit value "+ value+" "+currency);
    	if (value > 0) {
    		 this.balance+=value;
    		 }
    	else
    		throw e;
    }
    
    public void transfer (double transferValue , int personID) {
    	LowBalanceException e = new LowBalanceException("Current balance "+ balance + " " + currency + "is less than transfer value " + transferValue + " " + currency);
   	    if(balance>=transferValue) {
   	    	this.withdraw(transferValue);
            Customer.Accounts.get(Bank_System.objNoFinder(personID)+1).deposit(transferValue);
   	    	
   	        }
   	    else
   	    	throw e;
    }
    
    public int getId() {
		return id;
	}
    
    public abstract double Calc_balance();

	@Override
	public String toString() {
		return "\tBalance : " + balance + " " + currency + "\n\t"+"Account Type : " + account_type + "\n";
	}

	
    
    

}
