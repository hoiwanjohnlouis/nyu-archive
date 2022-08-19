public class CheckingAccount2Tester
{
	/* The main method(automatically invoked by JVM).
	* This method will create checking account object 
	* and will call methods on it.
	*/
	public static void main(String[] args)
	{
		System.out.println("Creating CheckingAccount2");
		//create a checking account object.
		CheckingAccount2 citiCheckingAccount = new CheckingAccount2();
		
		System.out.println("Depositing");
		citiCheckingAccount.deposit(2500);
		System.out.println("Withdrawing");
		citiCheckingAccount.withdrawal(1500);
		
		
		
		//show account number and maintenance flag.
		System.out.println("Checking Account Number: " + citiCheckingAccount.accountNumber);
		System.out.println("Maintenance Flag: " + citiCheckingAccount.getMaintenanceFlag());
	}
}
