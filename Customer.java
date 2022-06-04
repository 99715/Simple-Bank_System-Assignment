
package system;
import java.util.Scanner;
import java.util.ArrayList;

public class Customer extends Bank_System{
	private String name ;
    private int id ;
    private int phone_number;
    private int s = 0;
    private int m = 1;
    protected static int objArrNo ;
    protected static ArrayList<Account> Accounts = new ArrayList<>();
    static Scanner input = new Scanner (System.in);
    
    public Customer() {
		objArrNo = Bank_System.person.size();
		
	}
    
    public Customer(String name, int id , int phone_number ) {
        this.name = name ;
        this.id = id ;
        this.phone_number = phone_number ;
        objArrNo = Bank_System.person.size();
        
    }
    
    public Customer(String name , int phone_number , Account e ) {
        this.name = name ;
        this.id=e.getId();
        this.phone_number = phone_number ;
        objArrNo = Bank_System.person.size();
        
    }
    
    public void addaccount ( Account account) {
 	   Accounts.add(account); 
    }
    
    public void makeChecking_Acc(double balance) {
    	new Checking_Account(this.id,balance);
    }
    
    public void makeSaving_Acc(double balance) {
    	new Saving_Account(this.id,balance);
    }
    
    public void userAccounts () {
    	m=1;
    	for (int i = 0 ; i<Customer.Accounts.size() ; i++) {
        	 if(Customer.Accounts.get(i).getId() == this.id) {
        		System.out.print("Account "+m+" :\n"+Customer.Accounts.get(i));
        		m++;
        	 }
        }
    }
    
    public String getAccount() {
        String systemAccounts = "" ;
        for (int i = 0 ; i< Customer.Accounts.size() ; i++) {
            systemAccounts += Customer.Accounts.get(i) ;
           }
        return systemAccounts ;
    }
        
    public int numberAccounts() {
    	for (int i = 0 ; i<Customer.Accounts.size() ; i++) {
       	 if(Customer.Accounts.get(i).getId() == this.id) {
       		s++;
       	 }
    	 }
        return s;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setPhone_Number(int phone_number) {
    	this.phone_number = phone_number ;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    
    public double getPhone_Number() {
        return phone_number;
    }

    public int getId() {
        return id;
    }
    
    public void getinf() {
        System.out.println("\nName: " + name + "\nID : "+ id +"\nPhone Number : +20" + phone_number +"\nYou have " + this.numberAccounts()  + " Account\\s");
        this.userAccounts();
        
    }

    @Override
    
    public String toString () {
         
        return  name + "\t\t" + id + "\t\t" + "+20" + phone_number + "\n\n";
     }

}
