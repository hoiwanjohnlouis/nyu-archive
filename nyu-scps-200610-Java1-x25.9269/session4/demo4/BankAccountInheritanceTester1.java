public class BankAccountInheritanceTester1
{
	/* The main method(automatically invoked by JVM).
	* This method will create savings account object 
	*and call methods on it.
	*/
	public static void main(String[] args)
	{
		System.out.println("Creating SavingAccount");
		//create a saving account object.
		SavingsAccount1 citiSavingsAccount = new SavingsAccount1();
		doTransactionOnBankAccount(citiSavingsAccount);
		
	}

	/* A method that receives a BankAccount object (or any object from it's subclass)
	* and does deposit and withdrawal on the account.
	*/
	public static void doTransactionOnBankAccount(BankAccount anyBankAccount)
	{
		//deposit $400 and withdraw $300.
		System.out.println("Depositiing");
		anyBankAccount.deposit(400);
		System.out.println("Withdrawing");
		anyBankAccount.withdrawal(300);
		
		System.out.println("Accessing Account Info");
		//show account number and current balance.
		System.out.println("Bank Account Number: " +
		anyBankAccount.accountNumber);
		System.out.println("Bank Account Balance: " + anyBankAccount.getBalance());

	
	}
}
