public class BankAccount10Tester
{
	/** The main method(automatically invoked by JVM) that 
	* creates a new BankAccount object and stores and 
	* retrieves values of account number and balance.
	*/
	public static void main(String[] args)
	{
		System.out.println("Creating BankAccount101");
		// creates a new bank account Object
		BankAccount10 bankAccount101= new BankAccount10();

		System.out.println("Setting BankAccount101 InterestRate to default value");
		double interestRate = bankAccount101.setInterestRate();
		
		System.out.println("Accessing BankAccount101");
		// print out the initial account number and interestRate.
		System.out.println("Account Number: " 
				+ bankAccount101.getAccountNumber());
		System.out.println("Initial Balance: " 
				+ bankAccount101.getBalance());
		System.out.println("Interest Rate: " 
				+ interestRate);

		System.out.println("Creating BankAccount102");
		// creates a new bank account Object
		BankAccount10 bankAccount102= new BankAccount10(500.610);
		
		System.out.println("Setting BankAccount102 InterestRate to 4.5");
		boolean success = bankAccount102.setInterestRate(4.5);

		System.out.println("Accessing BankAccount102");
		// print out the initial account number and interestRate.
		System.out.println("Account Number: " 
				+ bankAccount102.getAccountNumber());
		System.out.println("Initial Balance: " 
				+ bankAccount102.getBalance());
		System.out.println("Interest Rate setting is successful? " 
				+ success);
		System.out.println("Interest Rate: " 
				+ bankAccount102.getInterestRate());

		System.out.println("Caling getNumberofAccountsOpened using BankAccount10 class");
		// print out the number of accounts opened.
		System.out.println("Total Number of Accounts Opened: " 
				+ BankAccount10.getNumberOfAccountsOpened());
		System.out.println("Caling getNumberofAccountsOpened using bankAccount101 object variable");
		System.out.println("Total Number of Accounts Opened: " 
				+ bankAccount101.getNumberOfAccountsOpened());
		System.out.println("Caling getNumberofAccountsOpened using bankAccount102 object variable");
		System.out.println("Total Number of Accounts Opened: " 
				+ bankAccount102.getNumberOfAccountsOpened());

	}
}
