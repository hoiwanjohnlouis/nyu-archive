public class CheckingAccount4Tester
{
	/* The main method(automatically invoked by JVM).
	* This method will create checking account object 
	* and will call methods on it.
	*/
	public static void main(String[] args)
	{
		System.out.println("Creating CheckingAccount4");
		//create a checking account object.
		CheckingAccount4 citiCheckingAccount = new CheckingAccount4(4000);
		
		System.out.println("Setting Interest Rate");
		citiCheckingAccount.setInterestRate(4.6);
		
		System.out.println("Account Info");
		System.out.println("Balance: " + citiCheckingAccount.getBalance());
		System.out.println("Interest Rate: " + citiCheckingAccount.getInterestRate());
		System.out.println("Interest: " + citiCheckingAccount.calculateInterest());
	}
}
