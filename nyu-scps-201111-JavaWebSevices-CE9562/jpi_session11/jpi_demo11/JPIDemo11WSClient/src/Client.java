import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.xml.rpc.ServiceException;

import mortgage.MortgageCalculator;
import mortgage.MortgageCalculatorService;
import mortgage.MortgageCalculatorServiceLocator;


public class Client {
	
	public static void main(String[] args){
		
		try {
			MortgageCalculatorServiceLocator locator = new MortgageCalculatorServiceLocator();
			MortgageCalculator service = locator.getMortgageCalculatorPort();
			double payment = service.calculateLoanAmount(4.5, 30, 2000);
			NumberFormat formatter = new DecimalFormat("##");
			System.out.println(formatter.format(payment));
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
