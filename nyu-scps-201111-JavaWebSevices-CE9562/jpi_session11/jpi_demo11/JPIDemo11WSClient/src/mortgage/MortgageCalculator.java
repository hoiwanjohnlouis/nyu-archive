/**
 * MortgageCalculator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mortgage;

public interface MortgageCalculator extends java.rmi.Remote {
    public double calculateLoanAmount(double arg0, int arg1, int arg2) throws java.rmi.RemoteException;
    public double calculateMonthlyPayment(int arg0, double arg1, int arg2) throws java.rmi.RemoteException;
}
