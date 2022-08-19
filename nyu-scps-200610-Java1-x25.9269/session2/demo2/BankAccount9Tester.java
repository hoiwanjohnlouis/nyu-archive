public class BankAccount9Tester
{
	/** The main method(automatically invoked by JVM) that 
	* creates a new BankAccount object and stores and 
	* retrieves values of account number and balance.
	*/
	public static void main(String[] args)
	{
		System.out.println("Creating BankAccount91");
		// creates a new bank account Object
		BankAccount9 bankAccount91= new BankAccount9();

		System.out.println("Setting BankAccount91 InterestRate to default value");
		double interestRate = bankAccount91.setInterestRate();
		
		System.out.println("Accessing BankAccount91");
		// print out the initial account number and interestRate.
		System.out.println("Account Number: " 
				+ bankAccount91.getAccountNumber());
		System.out.println("Initial Balance: " 
				+ bankAccount91.getBalance());
		System.out.println("Interest Rate: " 
				+ interestRate);

		System.out.println("Creating BankAccount92");
		// creates a new bank account Object
		BankAccount9 bankAccount92= new BankAccount9(500.69);
		
		System.out.println("Setting BankAccount92 InterestRate to 4.5");
		boolean success = bankAccount92.setInterestRate(4.5);

		System.out.println("Accessing BankAccount92");
		// print out the initial account number and interestRate.
		System.out.println("Account Number: " 
				+ bankAccount92.getAccountNumber());
		System.out.println("Initial Balance: " 
				+ bankAccount92.getBalance());
		System.out.println("Interest Rate setting is successful? " 
				+ success);
		System.out.println("Interest Rate: " 
				+ bankAccount92.getInterestRate());

		System.out.println("Caling getNumberofAccountsOpened using BankAccount9 class");
		// print out the number of accounts opened.
		System.out.println("Total Number of Accounts Opened: " 
				+ BankAccount9.getNumberOfAccountsOpened());
		System.out.println("Caling getNumberofAccountsOpened using bankAccount91 object variable");
		System.out.println("Total Number of Accounts Opened: " 
				+ bankAccount91.getNumberOfAccountsOpened());
		System.out.println("Caling getNumberofAccountsOpened using bankAccount92 object variable");
		System.out.println("Total Number of Accounts Opened: " 
				+ bankAccount92.getNumberOfAccountsOpened());

	}
}
