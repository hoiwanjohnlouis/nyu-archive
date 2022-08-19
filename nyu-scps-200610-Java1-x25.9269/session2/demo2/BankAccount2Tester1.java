public class BankAccount2Tester1
{
	/** The main method(automatically invoked by JVM) that 
	* creates a new BankAccount object and calls different methods
	* of the object. The main method calls getAccountNumber(), setAccountNumber, 
	* deposit and withdrawal methods on BankAccount Object.
	*/
	public static void main(String[] args){
		
		//local variables
		boolean success = false;
		int accountNumber =0;
		double amount = 0;

		System.out.println("Creating BankAccount2");
	// creates a new bank account Object
		BankAccount2 bankAccount= new BankAccount2();
		
		System.out.println("Accessing BankAccount2");
		// print out the initial account number - zero.
		System.out.println("Account Number before assignment: " + bankAccount.getAccountNumber());

		accountNumber =1234;

		// print the account number
		System.out.println("Setting account Number:  " + accountNumber);
		
		// set the account number
		success = bankAccount.setAccountNumber(accountNumber);

		// print success failure
		System.out.println("Successful setup of AccountNumber? " + success);
		
		// print out the account number after it is assigned 12345.
		System.out.println("Account Number after assignment: " + bankAccount.getAccountNumber());


		accountNumber = 8983;

		// print the account number
		System.out.println("Setting account Number:  " + accountNumber);

		// set the account number 
		success = bankAccount.setAccountNumber(accountNumber);

		// print success failure
		System.out.println("Successful setup of AccountNumber? " + success);
		
		// print out the account number after it is assigned 12345.
		System.out.println("Account Number after assignment: " + bankAccount.getAccountNumber());

		// deposit amount
		amount = 100;

		// print deposit amount
		System.out.println("Depositing:  " + amount);

		// deposit
		success = bankAccount.deposit(amount);
		
		// print success failure
		System.out.println("Successful deposit? " + success);
		
		//show balance
		System.out.println("After deposit, the balance is " + bankAccount.getBalance());

		// deposit amount
		amount = -300;

		// print deposit amount
		System.out.println("Depositing:  " + amount);

		
		// deposit
		success = bankAccount.deposit(-300);
		
		// print success failure
		System.out.println("Successful deposit? " + success);
		
		//show balance
		System.out.println("After deposit, the balance is " + bankAccount.getBalance());
		
		// withdrawal amount
		amount = 40;

		// print withdrawal amount
		System.out.println("Withdrawing:  " + amount);

		// withdraw
		success = bankAccount.withdrawal(40);
		
		// print success failure
		System.out.println("Successful withdrawal? " + success);
		
		// show balance
		System.out.println("After withdrawal, the balance is " + bankAccount.getBalance());

		// withdrawal amount
		amount = -400;

		// print deposit amount
		System.out.println("Withdrawing:  " + amount);

		// withdraw
		success = bankAccount.withdrawal(amount);
		
		// print success failure
		System.out.println("Successful withdrawal? " + success);
		
		// show balance
		System.out.println("After withdrawal, the balance is " + bankAccount.getBalance());

		// withdrawal amount
		amount = 200;

		// print deposit amount
		System.out.println("Withdrawing:  " + amount);
		
		// withdraw
		success = bankAccount.withdrawal(amount);
		
		// print success failure
		System.out.println("Successful withdrawal? " + success);
		
		// show balance
		System.out.println("After withdrawal, the balance is " + bankAccount.getBalance());
	}
}
