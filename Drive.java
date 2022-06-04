package system;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Drive {
	static int N = 0;
	static int again = 2 ;
    static int id , personID ;
    static int tries = 3 ;
    static double deposit , withdraw , transfer ;
    static Scanner input = new Scanner (System.in);
    static Customer user1 = new Customer ("ahmed", 5155 , 1013895726);
    static Customer user2 = new Customer ("mohamed", 5255 , 1247844562);


	public static void main(String[] args) {
	    String name = new String ();
	    Bank_System k = new Bank_System ();
	    System.out.println("I add two Customers to the arraylist of them.\nCastomer 1 have : \n\tname : ahmed\n\tID : 5155\n\tphone_no : +201013895726\n\n"
	    		+ "Castomer 2 have : \n\tname : mohamed\n\tID : 5255\n\tphone_no : +201247844562\n");
	 
	    k.addCustomer(user1);
		k.addCustomer(user2);
		
		
		System.out.println("\nnow, we will make for Customer1 Two Accounts : the first one is Saving Account and the other is Checking Account\n");
		k.newSavingaccount(user1.getId());
		k.newCheckingaccount(user1.getId());
		
		System.out.println("\nAlso, we will make for Customer2 Two Accounts but here the first one is Checking Account and the other is Saving Account\n");
		k.newSavingaccount(user2.getId());
		k.newCheckingaccount(user2.getId());
		
		System.out.println("\nwill make Customer1 first Account transfer  to Customer2 first Account by Input his ID {5255} and the tranfer value");
		try {
		System.out.print("Enter your other person ID : ");
	    personID = input.nextInt();
	    System.out.print("Enter the transfer value : ");
		transfer = input.nextInt();
		Customer.Accounts.get(Bank_System.objNoFinder(user1.getId())).transfer(transfer , personID);
		System.out.println("\nYour Balance Now is "+ Customer.Accounts.get(Bank_System.objNoFinder(user1.getId())).getBalance()+" "+ Customer.Accounts.get(Bank_System.objNoFinder(user1.getId())).getCurrency());
		}
		catch(InputMismatchException e) {
			e=new InputMismatchException("you can't use any characters or words for ID or Transfer Value");
			System.out.println(e.getMessage());
		}
		
		System.out.println("all Customer1 Data");
		k.getDataById(user1.getId());
		
		System.out.println("all Customer2 Data");
		k.getDataById(user2.getId());
		
		System.out.println("here we can add interests for all Accounts {as said in the assignment that 8% shared for all Accounts} by observe \"Balance After Adding Interests\"");
		for (int i = 0 ; i<Customer.Accounts.size() ; i++) {
       		 Customer.Accounts.get(i).Calc_balance();
       	 }
		
		System.out.println("Showing All of The Data in The System");
		System.out.println(k);
		
		
		System.out.println("from all data we get from the assignment i make a simple bank system\n");
		System.out.println("\t\t\t\t\t\t\t\tAhmed Shehata Bank_System");
		System.out.println("*Be Carefull You Have 3 tries to Right Login*\n");
		
			
try {
        while (tries-- > 0 || again == 2) {
         
	     System.out.print("\nEnter User Name : ");
	     name = input.next();
	     if(k.searchname(name)) {
	           System.out.print("Enter User ID : ");
	           id = input.nextInt();
	               if(k.checkidofName(name, id)) {
	            	 again=1;
	                 while (again==1 || again!=2){
	            		 repeatScope();
	            	}
	            	 
	                System.out.println("Thnx for your patient");
	                tries=3;

	            	}
	             	else
					System.out.println("Unvalid ID");
	             }
                 else
				 System.out.println("Unvalid Name");
       	 if(again == 2) {
       	  System.out.println("\t\t\t\t\t\t\t\tYou Have "+tries+ " try\\ies");
       	 }
       	  if (tries== 0) {
       	     System.out.println("\t\t\t\t\t\t\t*You Have Exceeded The Login Limit*");
       	     System.exit(0);
       	     }
		}
}
catch (InputMismatchException m) {
	m=new InputMismatchException("Input is not the same type of the parameter");
	System.out.println(m.getMessage());
}
		
	  }
	

       static void repeatScope() {
    	    Bank_System k = new Bank_System ();
    	    System.out.println("1. Customers Details");
			System.out.println("2. Current Customer Info");
			System.out.println("3. Other Customer Info By Using ID");
			System.out.println("4. Deposit");
			System.out.println("5. Withdraw");
			System.out.println("6. Transfer");
			System.out.println("7. Add New Checking Account");
			System.out.println("8. Add New Saving Account");
			System.out.println("9. add Interests For all");
			
			try {
				
			N = input.nextInt();
			switch (N) {
			case 1 :
				System.out.println(k);
				break;
			case 2 :
				k.getDataById(id);
				break ;
			case 3 :
			   	   System.out.println("Enter ID number :");
			   	   int searchedId = input.nextInt();
			   	   k.getDataById(searchedId);
			case 4 :
					System.out.print("Enter the deposit value : ");
					deposit = input.nextInt();
				    Customer.Accounts.get(Bank_System.objNoFinder(id)).deposit(deposit);
				    System.out.println("\nYour Balance Now is "+ Customer.Accounts.get(Bank_System.objNoFinder(id)).getBalance()+" "+ Customer.Accounts.get(Bank_System.objNoFinder(id)).getCurrency());
				break;
			case 5 :
					System.out.print("Enter the withdraw value : ");		
				    withdraw = input.nextInt();
				    Customer.Accounts.get(Bank_System.objNoFinder(id)).withdraw(withdraw);
				    System.out.println("\nYour Balance Now is "+ Customer.Accounts.get(Bank_System.objNoFinder(id)).getBalance()+" "+ Customer.Accounts.get(Bank_System.objNoFinder(id)).getCurrency());
				break;
			case 6 :
					System.out.print("Enter your other person ID : ");
				    personID = input.nextInt();
				    System.out.print("Enter the transfer value : ");
					transfer = input.nextInt();
					Customer.Accounts.get(Bank_System.objNoFinder(id)).transfer(transfer , personID);
					System.out.println("\nYour Balance Now is "+ Customer.Accounts.get(Bank_System.objNoFinder(id)).getBalance()+" "+ Customer.Accounts.get(Bank_System.objNoFinder(id)).getCurrency());
				break;
			case 7 :
				k.newCheckingaccount(id);
				break;
			case 8 :
				k.newSavingaccount(id);
				break;
			case 9 :
				for (int i = 0 ; i<Customer.Accounts.size() ; i++) {
		       		 Customer.Accounts.get(i).Calc_balance();
		       	 }
				break;
			case 10 :
				break;
       }
   	     System.out.println("\nDo U want any other survice ? \nFor \"Yes\" press 1\nFor \"No\" press 2");
   		 again = input.nextInt();

     }
			catch(InputMismatchException e) {
				e = new InputMismatchException("you can't use any characters or words for selection");
				System.out.println(e.getMessage());
       }
       
}
}
