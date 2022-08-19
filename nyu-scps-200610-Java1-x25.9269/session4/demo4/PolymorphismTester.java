public class PolymorphismTester {

	/* The main method(automatically invoked by JVM).
	* This method will create an instance of SavingAccount1 and
	* pass it  to callWithdrawal method. 
	*/
	public static void main(String[] args)
	{
		System.out.println("Creating CheckingAccount3");
		// create checking account object.
		CheckingAccount3 citiCheckingAccount = new CheckingAccount3();

		// shows maintenance flag initially.	
		System.out.println("Initially Account Maintenance Flag: " 
				+ citiCheckingAccount.getMaintenanceFlag());
		
		System.out.println("Depositing");
		//deposit $5000
		citiCheckingAccount.deposit(5000);
		
		System.out.println("Withdrawing");
		//pass checking account to callWithdrawal that expects bank acccount object.
		callWithdrawal(citiCheckingAccount);

		// shows maintenance flag initially.	
		System.out.println("After Withdrawal Account Maintenance Flag: " 
				+ citiCheckingAccount.getMaintenanceFlag());

		System.out.println("Creating SavingAccount1");
     	//create a saving account object.
		SavingsAccount1 citiSavingsAccount = new SavingsAccount1();
		
		//deposit $400 and withdraw $300.
		System.out.println("Depositiing");
		citiSavingsAccount.deposit(400);
		System.out.println("Withdrawing");
		citiSavingsAccount.withdrawal(300);

	}

	/** receives an object of BankAccount Type (or one of it's sub-classes)
	* and calls the withdrawal method on it.
	*/
	public static void callWithdrawal(BankAccount anyBankAccount)
	{
		System.out.println("In callWithdrawal");
		anyBankAccount.withdrawal(3500);
	}
}
