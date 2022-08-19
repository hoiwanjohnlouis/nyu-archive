public class MortgageCalculatorImpl implements MortgageCalculator{
    public Integer calculateMonthlyPayment(Mortgage mortgage){
        int years = mortgage.getYears();
        double interestRate = mortgage.getInterestRate();
        int loanAmount = mortgage.getLoanAmount();
        double monthlyInterestAmount = loanAmount * interestRate/12/100;
        double factor = 1 - Math.pow(1 + (interestRate/12/100), (years*12) * -1);
        double monthlyPayment = monthlyInterestAmount / factor;
        Integer returnVal = new Integer((int) Math.round(monthlyPayment));
        return returnVal ;
    }
    public Integer calculateLoanAmount(Mortgage mortgage){
        int years = mortgage.getYears();
        double interestRate = mortgage.getInterestRate();
        int monthlyPayment = mortgage.getMonthlyPayment();
        double factor = 1 - Math.pow(1 + (interestRate/12/100), (years*12) * -1);
        double monthlyInterestAmount =  monthlyPayment* factor;
        int loanAmount = (int) (monthlyInterestAmount/interestRate*12*100);
        Integer returnVal = new Integer((int) loanAmount);
        return returnVal ;
    }
}
