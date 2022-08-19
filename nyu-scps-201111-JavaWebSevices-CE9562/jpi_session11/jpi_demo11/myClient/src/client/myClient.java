package client;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import mortgage.MortgageCalculator;
import mortgage.MortgageCalculatorService;
import mortgage.MortgageCalculatorServiceLocator;

public class myClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			MortgageCalculatorService locator = new mortgage.MortgageCalculatorServiceLocator();
			MortgageCalculator stub = locator.getMortgageCalculatorPort();
			
			double amt = stub.calculateLoanAmount(4.24, 30, 1000);
			double pay = stub.calculateMonthlyPayment(200000, 4.25, 30);
			
			System.out.println("Amount is " + amt);
			System.out.println("Payment is " + pay);
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
