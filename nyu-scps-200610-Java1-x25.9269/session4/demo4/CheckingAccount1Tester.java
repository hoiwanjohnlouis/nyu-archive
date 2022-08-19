public class CheckingAccount1Tester
{
	/* The main method(automatically invoked by JVM).
	* This method will create checking account object 
	* and will call methods on it.
	*/
	public static void main(String[] args)
	{
		System.out.println("Creating CheckingAccount1");
		//create a checking account object.
		CheckingAccount1 citiCheckingAccount = new CheckingAccount1();
		
		// store last issued check number on check book.
		int lastCheckNumber = citiCheckingAccount.requestLastCheckNumber(100);
		
		//show account number and current balance.
		System.out.println("Checking Account Number: " + citiCheckingAccount.accountNumber);
		System.out.println("Last Issued Check Number: " + citiCheckingAccount.getLastCheckNumber());
	}
}
