import junit.framework.TestCase;


public class BankAccountJUnitTester extends TestCase {
	
	public void testPositiveDeposit(){
		boolean success = false;
		BankAccount b = new BankAccount();
		success = b.deposit(300);
		TestCase.assertTrue(success);
	}
	public void testNegativeDeposit(){
		boolean success = false;
		BankAccount b = new BankAccount();
		success = b.deposit(-300);
		TestCase.assertFalse(success);
	}

	public void testZeroDeposit(){
		boolean success = false;
		BankAccount b = new BankAccount();
		success = b.deposit(0);
		TestCase.assertFalse(success);
	}

	public void testGetBalance(){
		double initialDeposit =500.45;
		BankAccount b = new BankAccount(initialDeposit);
		TestCase.assertEquals(initialDeposit,b.getBalance());
		double depositAmount = 400.23;
		b.deposit(depositAmount);
		TestCase.assertEquals(initialDeposit+depositAmount,b.getBalance());
		double withdrawalAmount = 300.23;
		b.withdrawal(withdrawalAmount);
		TestCase.assertEquals(initialDeposit+depositAmount-withdrawalAmount,b.getBalance());
		
	}

}
