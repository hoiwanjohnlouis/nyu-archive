import java.io.Serializable;

public class Mortgage implements Serializable{

    public static final long serialVersionUID=1;

    private int loanAmount;
    private double interestRate;
    private int years;
    private int mortgageAmount;
    private int monthlyPayment;

    public int getMonthlyPayment() {
        return monthlyPayment;
    }
    public void setMonthlyPayment(int monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
    public double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    public int getLoanAmount() {
        return loanAmount;
    }
    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }
    public int getMortgageAmount() {
        return mortgageAmount;
    }
    public void setMortgageAmount(int mortgageAmount) {
        this.mortgageAmount = mortgageAmount;
    }
    public int getYears() {
        return years;
    }
    public void setYears(int years) {
        this.years = years;
    }
}
