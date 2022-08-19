public class BankAccount12Tester
{
	/** The main method(automatically invoked by JVM) that 
	* creates a new BankAccount object and stores and 
	* retrieves values of account number and balance.
	*/
	public static void main(String[] args)
	{
		System.out.println("Creating BankAccount121");
		// creates a new bank account Object
		BankAccount12 bankAccount121= new BankAccount12();

		System.out.println("Setting BankAccount121 InterestRate to default value");
		double interestRate = bankAccount121.setInterestRate();
		
		System.out.println("Accessing BankAccount121");
		// print out the initial account number and interestRate.
		System.out.println("Account Number: " 
				+ bankAccount121.accountNumber);
		System.out.println("Initial Balance: " 
				+ bankAccount121.getBalance());
		System.out.println("Interest Rate: " 
				+ interestRate);

		System.out.println("Creating BankAccount122");
		// creates a new bank account Object
		BankAccount12 bankAccount122= new BankAccount12(500.612);
		
		System.out.println("Setting BankAccount122 InterestRate to 4.5");
		boolean success = bankAccount122.setInterestRate(4.5);

		System.out.println("Accessing BankAccount122");
		// print out the initial account number and interestRate.
		System.out.println("Account Number: " 
				+ bankAccount122.accountNumber);
		System.out.println("Initial Balance: " 
				+ bankAccount122.getBalance());
		System.out.println("Interest Rate setting is successful? " 
				+ success);
		System.out.println("Interest Rate: " 
				+ bankAccount122.getInterestRate());

		System.out.println("Caling getNumberofAccountsOpened using BankAccount12 class");
		// print out the number of accounts opened.
		System.out.println("Total Number of Accounts Opened: " 
				+ BankAccount12.getNumberOfAccountsOpened());
		System.out.println("Caling getNumberofAccountsOpened using bankAccount121 object variable");
		System.out.println("Total Number of Accounts Opened: " 
				+ bankAccount121.getNumberOfAccountsOpened());
		System.out.println("Caling getNumberofAccountsOpened using bankAccount122 object variable");
		System.out.println("Total Number of Accounts Opened: " 
				+ bankAccount122.getNumberOfAccountsOpened());
		System.out.println("Default Interest Rate: " 
				+ BankAccount12.DEFAULT_INTEREST_RATE);


	}
}
