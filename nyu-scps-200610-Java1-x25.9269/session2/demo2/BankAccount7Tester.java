public class BankAccount7Tester
{
	/** The main method(automatically invoked by JVM) that 
	* creates a new BankAccount object and stores and 
	* retrieves values of account number and balance.
	*/
	public static void main(String[] args)
	{
		System.out.println("Creating BankAccount71");
		// creates a new bank account Object
		BankAccount7 bankAccount71= new BankAccount7(879);

		System.out.println("Setting BankAccount71 InterestRate to default value");
		double interestRate = bankAccount71.setInterestRate();
		
		System.out.println("Accessing BankAccount71");
		// print out the initial account number and interestRate.
		System.out.println("Account Number: " 
				+ bankAccount71.getAccountNumber());
		System.out.println("Initial Balance: " 
				+ bankAccount71.getBalance());
		System.out.println("Interest Rate: " 
				+ interestRate);

		System.out.println("Creating BankAccount72");
		// creates a new bank account Object
		BankAccount7 bankAccount72= new BankAccount7(1234,500.67);
		
		System.out.println("Setting BankAccount72 InterestRate to 4.5");
		boolean success = bankAccount72.setInterestRate(4.5);

		System.out.println("Accessing BankAccount72");
		// print out the initial account number and interestRate.
		System.out.println("Account Number: " 
				+ bankAccount72.getAccountNumber());
		System.out.println("Initial Balance: " 
				+ bankAccount72.getBalance());
		System.out.println("Interest Rate setting is successful? " 
				+ success);
		System.out.println("Interest Rate: " 
				+ bankAccount72.getInterestRate());
	}
}
