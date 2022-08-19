public class SavingsAccount1Tester
{
	/* The main method(automatically invoked by JVM).
	* This method will create savings account object 
	* and will call methods on it.
	*/
	public static void main(String[] args)
	{
		System.out.println("Creating SavingAccount1");
		
		//create a saving account object.
		SavingsAccount1 citiSavingsAccount = new SavingsAccount1();
		
		//deposit $400 and withdraw $300.
		System.out.println("Depositiing");
		citiSavingsAccount.deposit(400);
		System.out.println("Withdrawing");
		citiSavingsAccount.withdrawal(300);
		
		//show account number and current balance.
		System.out.println("Accessing Account Info");
		System.out.println("Savings Account Number: " + citiSavingsAccount.accountNumber);
		System.out.println("Savings Account Balance: " + citiSavingsAccount.getBalance());
	}
}
