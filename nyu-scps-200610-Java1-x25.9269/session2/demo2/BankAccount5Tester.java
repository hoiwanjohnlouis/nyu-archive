public class BankAccount5Tester
{
	/** The main method(automatically invoked by JVM) that 
	* creates a new BankAccount object and stores and 
	* retrieves values of account number and balance.
	*/
	public static void main(String[] args)
	{
		System.out.println("Creating BankAccount51");
		// creates a new bank account Object
		BankAccount5 bankAccount51= new BankAccount5(879);
		
		System.out.println("Accessing bankAccount51");
		
		// print out the initial account number and balance - zero.
		System.out.println("Account Number: " 
				+ bankAccount51.getAccountNumber());
		System.out.println("Initial Balance: " 
				+ bankAccount51.getBalance());

		System.out.println("Creating BankAccount52");
		// creates a new bank account Object
		BankAccount5 bankAccount52= new BankAccount5(1234,500.67);
		
		System.out.println("Accessing bankAccount52");
		// print out the initial account number and balance - zero.
		System.out.println("Account Number: " 
				+ bankAccount52.getAccountNumber());
		System.out.println("Initial Balance: " 
				+ bankAccount52.getBalance());
	}
}
