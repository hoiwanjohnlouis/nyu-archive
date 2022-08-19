/**
 * MortgageCalculatorServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mortgage;

public class MortgageCalculatorServiceLocator extends org.apache.axis.client.Service implements mortgage.MortgageCalculatorService {

    public MortgageCalculatorServiceLocator() {
    }


    public MortgageCalculatorServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MortgageCalculatorServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MortgageCalculatorPort
    private java.lang.String MortgageCalculatorPort_address = "http://localhost:8080/work/services/MortgageService";

    public java.lang.String getMortgageCalculatorPortAddress() {
        return MortgageCalculatorPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MortgageCalculatorPortWSDDServiceName = "MortgageCalculatorPort";

    public java.lang.String getMortgageCalculatorPortWSDDServiceName() {
        return MortgageCalculatorPortWSDDServiceName;
    }

    public void setMortgageCalculatorPortWSDDServiceName(java.lang.String name) {
        MortgageCalculatorPortWSDDServiceName = name;
    }

    public mortgage.MortgageCalculator getMortgageCalculatorPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MortgageCalculatorPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMortgageCalculatorPort(endpoint);
    }

    public mortgage.MortgageCalculator getMortgageCalculatorPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            mortgage.MortgageCalculatorServiceSoapBindingStub _stub = new mortgage.MortgageCalculatorServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getMortgageCalculatorPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMortgageCalculatorPortEndpointAddress(java.lang.String address) {
        MortgageCalculatorPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (mortgage.MortgageCalculator.class.isAssignableFrom(serviceEndpointInterface)) {
                mortgage.MortgageCalculatorServiceSoapBindingStub _stub = new mortgage.MortgageCalculatorServiceSoapBindingStub(new java.net.URL(MortgageCalculatorPort_address), this);
                _stub.setPortName(getMortgageCalculatorPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("MortgageCalculatorPort".equals(inputPortName)) {
            return getMortgageCalculatorPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://mortgage/", "MortgageCalculatorService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://mortgage/", "MortgageCalculatorPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MortgageCalculatorPort".equals(portName)) {
            setMortgageCalculatorPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
