public class BankAccount2Tester2
{
	/** The main method(automatically invoked by JVM) that 
	* creates a new BankAccount object and calls different methods
	* of the object. The main method accesses public fields instead of methods.
	*/
	public static void main(String[] args){
		
		//local variables
		int accountNumber =0;
		double amount = 0;

		System.out.println("Creating BankAccount2");
		// creates a new bank account Object
		BankAccount2 bankAccount= new BankAccount2();
		
		System.out.println("Accessing BankAccount2");
		// print out the initial account number - zero.
		System.out.println("Account Number before assignment: " + bankAccount.accountNumber);

		accountNumber =1234;

		// print the account number
		System.out.println("Setting account Number:  " + accountNumber);
		
		// set the account number
		bankAccount.accountNumber=accountNumber;

		// print out the account number after it is assigned 12345.
		System.out.println("Account Number after assignment: " + bankAccount.accountNumber);


		accountNumber = 8983;

		// print the account number
		System.out.println("Setting account Number:  " + accountNumber);

		bankAccount.accountNumber=accountNumber;

		// print out the account number after it is assigned 12345.
		System.out.println("Account Number after assignment: " + bankAccount.accountNumber);

		// deposit amount
		amount = 100;

		// print deposit amount
		System.out.println("Depositing:  " + amount);

		// deposit
		bankAccount.balance += amount;
		
		//show balance
		System.out.println("After deposit, the balance is " + bankAccount.balance);

		// deposit amount
		amount = -300;

		// print deposit amount
		System.out.println("Depositing:  " + amount);

		
		// deposit
		bankAccount.balance += amount;
		
		//show balance
		System.out.println("After deposit, the balance is " + bankAccount.balance);
		
		// withdrawal amount
		amount = 40;

		// print withdrawal amount
		System.out.println("Withdrawing:  " + amount);

		// deposit
		bankAccount.balance -= amount;
		
		//show balance
		System.out.println("After deposit, the balance is " + bankAccount.balance);
		
		// withdrawal amount
		amount = -400;

		// print deposit amount
		System.out.println("Withdrawing:  " + amount);

		// withdrawal
		bankAccount.balance -= amount;
		
		// show balance
		System.out.println("After withdrawal, the balance is " + bankAccount.balance);

		// withdrawal amount
		amount = 200;

		// print deposit amount
		System.out.println("Withdrawing:  " + amount);
		
		// withdraw
		bankAccount.balance -= amount;
		
		// show balance
		System.out.println("After withdrawal, the balance is " + bankAccount.balance);
	}
}
