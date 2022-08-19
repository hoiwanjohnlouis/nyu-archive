public class BankAccount1Tester
{
	/** The main method(automatically invoked by JVM) that 
	* creates a new BankAccount object and stores and 
	* retrieves values of account number and balance.
	*/
	public static void main(String[] args)
	{
		// creates a new bank account Object
		BankAccount1 bankAccount= new BankAccount1();
		
		// print out the initial account number and balance - zero.
		System.out.println("Account Number before assignment: " 
				+ bankAccount.accountNumber);
		System.out.println("Initial Balance: " 
				+ bankAccount.balance);

		// set the account number 
		bankAccount.accountNumber =12345;
		// set the balance
		bankAccount.balance =600;


		// print out the account number after it is assigned 12345.
		System.out.println("Account Number after assignment: " 
			+ bankAccount.accountNumber);

		//print out the balance after it is assigned $600.
		System.out.println("Balance after assignment: " 
			+ bankAccount.balance);

	}
}
