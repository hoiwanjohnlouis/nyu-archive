public class BankAccount6Tester
{
	/** The main method(automatically invoked by JVM) that 
	* creates a new BankAccount object and stores and 
	* retrieves values of account number and balance.
	*/
	public static void main(String[] args)
	{
		System.out.println("Creating BankAccount61");
		// creates a new bank account Object
		BankAccount6 bankAccount61= new BankAccount6(879);

		System.out.println("Setting BankAccount61 InterestRate to default value");
		double interestRate = bankAccount61.setInterestRate();
		
		System.out.println("Accessing BankAccount61");
		// print out the initial account number and interestRate.
		System.out.println("Account Number: " 
				+ bankAccount61.getAccountNumber());
		System.out.println("Interest Rate: " 
				+ interestRate);

		System.out.println("Creating BankAccount62");
		// creates a new bank account Object
		BankAccount6 bankAccount62= new BankAccount6(1234,500.67);

		System.out.println("Setting BankAccount62 InterestRate to 4.5");
		boolean success = bankAccount62.setInterestRate(4.5);

		System.out.println("Accessing BankAccount62");
		// print out the initial account number and interestRate.
		System.out.println("Account Number: " 
				+ bankAccount62.getAccountNumber());
		System.out.println("Interest Rate setting is successful? " 
				+ success);
		System.out.println("Interest Rate: " 
				+ bankAccount62.getInterestRate());
	}
}
