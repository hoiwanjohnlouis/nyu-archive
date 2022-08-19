package mortgage;

public class MortgageCalculatorProxy implements mortgage.MortgageCalculator {
  private String _endpoint = null;
  private mortgage.MortgageCalculator mortgageCalculator = null;
  
  public MortgageCalculatorProxy() {
    _initMortgageCalculatorProxy();
  }
  
  public MortgageCalculatorProxy(String endpoint) {
    _endpoint = endpoint;
    _initMortgageCalculatorProxy();
  }
  
  private void _initMortgageCalculatorProxy() {
    try {
      mortgageCalculator = (new mortgage.MortgageCalculatorServiceLocator()).getMortgageCalculatorPort();
      if (mortgageCalculator != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)mortgageCalculator)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)mortgageCalculator)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (mortgageCalculator != null)
      ((javax.xml.rpc.Stub)mortgageCalculator)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public mortgage.MortgageCalculator getMortgageCalculator() {
    if (mortgageCalculator == null)
      _initMortgageCalculatorProxy();
    return mortgageCalculator;
  }
  
  public double calculateLoanAmount(double arg0, int arg1, int arg2) throws java.rmi.RemoteException{
    if (mortgageCalculator == null)
      _initMortgageCalculatorProxy();
    return mortgageCalculator.calculateLoanAmount(arg0, arg1, arg2);
  }
  
  public double calculateMonthlyPayment(int arg0, double arg1, int arg2) throws java.rmi.RemoteException{
    if (mortgageCalculator == null)
      _initMortgageCalculatorProxy();
    return mortgageCalculator.calculateMonthlyPayment(arg0, arg1, arg2);
  }
  
  
}