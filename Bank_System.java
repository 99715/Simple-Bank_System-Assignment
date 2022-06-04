
package system;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank_System {
   
   static Scanner input = new Scanner(System.in);
   protected static ArrayList<Customer> person = new ArrayList<Customer>();
   protected static ArrayList<Employee> stuff = new ArrayList<>();
   
   public void newCheckingaccount (int accountID) {
	       for(int i = 2 ; i > -1 ; i--) {
		   double accountbalance;
		   System.out.print ("Enter Balance : ");
	       try {
		      accountbalance = input.nextDouble();
		      new Checking_Account(accountID,accountbalance);
	          System.out.println("The New Account Created");
	          break;
	       }
	       catch (LowBalanceException e){
	    	   e = new LowBalanceException("\n\t\t\t\tBalance less than 1000 EGP will not be allowed\n");
	    	   System.out.println(e.getAlert()+"\t\t\tPlease Enter A Balance Greater Than or Equals To 1000 EGP You Have " + i +" try\\ies") ;  
	       }
	       }   
   }

   public void newSavingaccount (int accountID) {
	   for(int i = 3 ; i > 0 ; i--) {
		   System.out.print ("Enter Balance : ");
		   double accountbalance ; 
	       try {
	    	  accountbalance = input.nextDouble();
	    	  new Saving_Account(accountID,accountbalance);
	          System.out.println("The New Account Created");
	          break;
	       }
	       catch (LowBalanceException e){
	    	   e = new LowBalanceException("\n\t\t\t\tBalance less than 1000 EGP will not be allowed\n");
	    	   System.out.println(e.getAlert()+"\t\t\tPlease Enter A Balance Greater Than or Equals To 1000 EGP You Have " + i +" try\\ies") ;  
	       }
	   }
	       
   }

   public void addCustomer ( Customer account) {
	      person.add(account); 
      }
   
   protected boolean searchname (String name) {
   	boolean get = false;
   	for (int i = 0 ; i<Bank_System.person.size() ; i++) {
        	 if(Bank_System.person.get(i).getName().equals(name)) {
        		get = true ;
        		break;
        	 }
        	 else
        		get = false ;
        }
   	return get ;
   } 
   
   protected static boolean searchid (int id) {  
   	   boolean get = false;
   	   for (int i = 0 ; i<person.size() ; i++) {
       	   if(person.get(i).getId() == id) {
         		 get =true ;
         		 break;
         	 }
         	else
         	   get = false ;
         }
    	return get ;
    }

   public boolean checkidofName (String name , int id) {
	   boolean get = false ;
	       	 if(this.searchname(name)) {
	       		if(searchid(id)) {
	       			if(person.get(objNoFinder(id)).getName().equals(name)) {
	       				get = true ;
	       			}
	       			else
	       				get = false;
	       		}
	       		else
       				get = false ;
	       	 }
	       	else
   				get = false ;
	       	 
			return get;
	       }
   
   public void getDataById (int id) {
   	   person.get(Bank_System.objNoFinder(id)).getinf() ;
       if(!Bank_System.searchid(id))
       throw new UnDefinedUserException("No User With That ID"); 
   }
   
   protected static int objNoFinder (int id){
    	 int v = 0 ;
    	 for (int i = 0 ; i<person.size() ; i++) {
        	 if(person.get(i).getId() == id) {
        		 v = i ;
        		 break ;
        	 }
        	 else
        		 v = Customer.objArrNo ;
         }
 		return v ;
  }

   public String customerInfo() {
	String mycustomers = "" ;
	 for (int i = 0 ; i< person.size() ; i++) {
		 mycustomers += person.get(i) ;
	 }
	return mycustomers ;
   }

   public String AccountsInfo() {
	String myaccounts = "" ;
	 for (int i = 0 ; i< Customer.Accounts.size() ; i++) {
		 myaccounts +=  Customer.Accounts.get(i) ;
	 }
	return myaccounts ;
   }

   public String employeeInfo() {
	 String myemployees = "" ;
	 for (int i = 0 ; i< stuff.size() ; i++) {
    	myemployees += stuff.get(i) ;
     }
	return myemployees ;
    }

   public String toString() {
        return customerInfo()  + AccountsInfo() + employeeInfo();
   }

}