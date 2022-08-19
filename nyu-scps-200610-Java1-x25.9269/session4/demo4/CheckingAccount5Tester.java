public class CheckingAccount5Tester
{
	/* The main method(automatically invoked by JVM).
	* This method will create checking account object 
	* and will call methods on it.
	*/
	public static void main(String[] args)
	{
		System.out.println("Creating CheckingAccount5");
		//create a checking account object.
		CheckingAccount5 citiCheckingAccount = new CheckingAccount5(5000);
		
		System.out.println("Setting Interest Rate");
		citiCheckingAccount.setInterestRate(5.6);
		System.out.println("Setting Tax Rate");
		citiCheckingAccount.setTaxRate(25);
		
		System.out.println("Account Info");
		System.out.println("Balance: " + citiCheckingAccount.getBalance());
		System.out.println("Interest Rate: " + citiCheckingAccount.getInterestRate());
		System.out.println("Interest: " + citiCheckingAccount.calculateInterest());
		System.out.println("Tax Rate: " + citiCheckingAccount.getTaxRate());
		System.out.println("Tax: " + citiCheckingAccount.calculateTax());
	}
}
