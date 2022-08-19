public class CheckingAccount3Tester
{
	/* The main method(automatically invoked by JVM).
	* This method will create checking account object 
	* and will call methods on it.
	*/
	public static void main(String[] args)
	{
		System.out.println("Creating CheckingAccount3");
		//create a checking account object.
		CheckingAccount3 citiCheckingAccount = new CheckingAccount3(300.45);
		
		System.out.println("Depositing");
		citiCheckingAccount.deposit(2500);
		System.out.println("Withdrawing");
		citiCheckingAccount.withdrawal(1500);
		
		
		
		//show account number and maintenance flag.
		System.out.println("Checking Account Number: " + citiCheckingAccount.accountNumber);
		System.out.println("Maintenance Flag: " + citiCheckingAccount.getMaintenanceFlag());
	}
}
