package mortgage;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name="MortgageCalculatorPortType", 
            targetNamespace = "http://www.scps.nyu.edu/jws/mortgage")

@SOAPBinding(
style = SOAPBinding.Style.DOCUMENT,
use = SOAPBinding.Use.LITERAL)

public class MortgageCalculator{

	
	public double calculateMonthlyPayment(@WebParam(name="AmountOfLoan") int loanAmount, 
			                              @WebParam(name="InterestRate") double interestRate, 
			                              @WebParam(name="NumberOfYear") int years){
		double monthlyInterestAmount = loanAmount * interestRate/12/100;
		double factor = 1 - Math.pow(1 + (interestRate/12/100), (years*12) * -1);
		double monthlyPayment = monthlyInterestAmount / factor;
		return Math.round(monthlyPayment);
	}
	public double calculateLoanAmount(double interestRate, int years, int monthlyPayment){
		double factor = 1 - Math.pow(1 + (interestRate/12/100), (years*12) * -1);
		double monthlyInterestAmount =  monthlyPayment* factor;
		double loanAmount = Math.round(monthlyInterestAmount/interestRate*12*100);
		return loanAmount;
	}
}
