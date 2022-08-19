public class BankAccount11Tester
{
	/** The main method(automatically invoked by JVM) that 
	* creates a new BankAccount object and stores and 
	* retrieves values of account number and balance.
	*/
	public static void main(String[] args)
	{
		System.out.println("Creating BankAccount111");
		// creates a new bank account Object
		BankAccount11 bankAccount111= new BankAccount11();

		System.out.println("Setting BankAccount111 InterestRate to default value");
		double interestRate = bankAccount111.setInterestRate();
		
		System.out.println("Accessing BankAccount111");
		// print out the initial account number and interestRate.
		System.out.println("Account Number: " 
				+ bankAccount111.accountNumber);
		System.out.println("Initial Balance: " 
				+ bankAccount111.getBalance());
		System.out.println("Interest Rate: " 
				+ interestRate);

		System.out.println("Creating BankAccount112");
		// creates a new bank account Object
		BankAccount11 bankAccount112= new BankAccount11(500.611);
		
		System.out.println("Setting BankAccount112 InterestRate to 4.5");
		boolean success = bankAccount112.setInterestRate(4.5);

		System.out.println("Accessing BankAccount112");
		// print out the initial account number and interestRate.
		System.out.println("Account Number: " 
				+ bankAccount112.accountNumber);
		System.out.println("Initial Balance: " 
				+ bankAccount112.getBalance());
		System.out.println("Interest Rate setting is successful? " 
				+ success);
		System.out.println("Interest Rate: " 
				+ bankAccount112.getInterestRate());

		System.out.println("Caling getNumberofAccountsOpened using BankAccount11 class");
		// print out the number of accounts opened.
		System.out.println("Total Number of Accounts Opened: " 
				+ BankAccount11.getNumberOfAccountsOpened());
		System.out.println("Caling getNumberofAccountsOpened using bankAccount111 object variable");
		System.out.println("Total Number of Accounts Opened: " 
				+ bankAccount111.getNumberOfAccountsOpened());
		System.out.println("Caling getNumberofAccountsOpened using bankAccount112 object variable");
		System.out.println("Total Number of Accounts Opened: " 
				+ bankAccount112.getNumberOfAccountsOpened());

	}
}
