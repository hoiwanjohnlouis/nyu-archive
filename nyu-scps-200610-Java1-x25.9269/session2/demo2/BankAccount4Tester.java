public class BankAccount4Tester
{
	/** The main method(automatically invoked by JVM) that 
	* creates a new BankAccount object and stores and 
	* retrieves values of account number and balance.
	*/
	public static void main(String[] args)
	{
		System.out.println("Creating BankAccount4");
		// creates a new bank account Object
		BankAccount4 bankAccount4= new BankAccount4(879);
		
		System.out.println("Accessing bankAccount4");
		// print out the initial account number and balance - zero.
		System.out.println("Account Number: " 
				+ bankAccount4.getAccountNumber());
		System.out.println("Initial Balance: " 
				+ bankAccount4.getBalance());
	}
}
