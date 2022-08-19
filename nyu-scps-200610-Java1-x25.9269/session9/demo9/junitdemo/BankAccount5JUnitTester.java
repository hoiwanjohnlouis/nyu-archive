import junit.framework.TestCase;

public class BankAccount5JUnitTester extends TestCase {
	
	public void testPositiveDeposit(){
		try{
			double depositAmount =300.24;
			BankAccount5 b = new BankAccount5();
			b.deposit(depositAmount);
			TestCase.assertEquals(depositAmount,b.getBalance());
		}
		catch(Exception e){
			
		}
	}
	public void testNegativeWithdrawalWithException(){
		double withdrawalAmount = -300.23;
		try{
			BankAccount5 b = new BankAccount5();
			b.withdrawal(withdrawalAmount);
			TestCase.fail("Negative Withdrawal Succeeded");
		}
		catch(Exception e){
			TestCase.assertEquals(new NegativeAmountException(withdrawalAmount),e);
		}
	}

	public void testInsufficientBalanceException(){
		double withdrawalAmount = 400.45;
		try{
			BankAccount5 b = new BankAccount5();
			b.withdrawal(withdrawalAmount);
			TestCase.fail("Insufficient Balance Succeeded");
		}
		catch(Exception e){
			TestCase.assertEquals(new InsufficientBalanceException(withdrawalAmount,0),e);
		}
	}
}
