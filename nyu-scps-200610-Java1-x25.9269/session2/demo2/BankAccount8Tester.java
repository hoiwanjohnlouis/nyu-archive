public class BankAccount8Tester
{
	/** The main method(automatically invoked by JVM) that 
	* creates a new BankAccount object and stores and 
	* retrieves values of account number and balance.
	*/
	public static void main(String[] args)
	{
		System.out.println("Creating BankAccount81");
		// creates a new bank account Object
		BankAccount8 bankAccount81= new BankAccount8();

		System.out.println("Setting BankAccount81 InterestRate to default value");
		double interestRate = bankAccount81.setInterestRate();
		
		System.out.println("Accessing BankAccount81");
		// print out the initial account number and interestRate.
		System.out.println("Account Number: " 
				+ bankAccount81.getAccountNumber());
		System.out.println("Initial Balance: " 
				+ bankAccount81.getBalance());
		System.out.println("Interest Rate: " 
				+ interestRate);

		System.out.println("Creating BankAccount82");
		// creates a new bank account Object
		BankAccount8 bankAccount82= new BankAccount8(500.68);
		
		System.out.println("Setting BankAccount82 InterestRate to 4.5");
		boolean success = bankAccount82.setInterestRate(4.5);

		System.out.println("Accessing BankAccount82");
		// print out the initial account number and interestRate.
		System.out.println("Account Number: " 
				+ bankAccount82.getAccountNumber());
		System.out.println("Initial Balance: " 
				+ bankAccount82.getBalance());
		System.out.println("Interest Rate setting is successful? " 
				+ success);
		System.out.println("Interest Rate: " 
				+ bankAccount82.getInterestRate());
	}
}
