// this class does not compile
public class BankAccount3Tester
{
	/** The main method(automatically invoked by JVM) that 
	* creates a new BankAccount object and calls different methods
	* of the object. The main method tries to access private field but can not.
	*/
	public static void main(String[] args){
		
		//local variables
		int accountNumber =0;
		double amount = 0;

		System.out.println("Creating BankAccount3");
		// creates a new bank account Object
		BankAccount3 bankAccount= new BankAccount3();
		
		System.out.println("Accessing BankAccount3");
		
		// print out the initial account number - zero.
		System.out.println("Account Number before assignment: " + bankAccount.accountNumber);

		accountNumber =1234;

		// print the account number
		System.out.println("Setting account Number:  " + accountNumber);
		
		// set the account number
		bankAccount.accountNumber=accountNumber;

	}
}
