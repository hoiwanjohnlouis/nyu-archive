public class BankAccountInheritanceTester4
{
	/* The main method(automatically invoked by JVM).
	* This method will create savings account object 
	*and call methods on it.
	*/
	public static void main(String[] args)
	{
		if (args.length == 0)
		{
			System.out.println("Creating BankAccount");
			//create a bank account object.
			BankAccount citiBankAccount = new BankAccount();
			
			//cast it to Saving Account - even if it is wroing.
			SavingsAccount1 citiSavingsAccount= (SavingsAccount1) citiBankAccount;
			
			doTransactionOnSavingsAccount(citiSavingsAccount);
		}
		else
		{
			System.out.println("Creating SavingsAccount");
			// create a savings account object.
			SavingsAccount1 citiSavingsAccount= new SavingsAccount1();
			//passing SavingAccount Object correctly.
			doTransactionOnSavingsAccount(citiSavingsAccount);
	
		}
		
	}

	/* A method that receives a SavingAccount object (or any object from it's subclass)
	* and does deposit and withdrawal on the account.
	*/
	public static void doTransactionOnSavingsAccount(SavingsAccount1 anySavingsAccount)
	{
		//deposit $400 and withdraw $300.
		System.out.println("Depositiing");
		anySavingsAccount.deposit(400);
		System.out.println("Withdrawing");
		anySavingsAccount.withdrawal(300);
		
		System.out.println("Accessing Account Info");
		//show account number and current balance.
		System.out.println("Bank Account Number: " +
		anySavingsAccount.accountNumber);
		System.out.println("Bank Account Balance: " + anySavingsAccount.getBalance());

	
	}
}
