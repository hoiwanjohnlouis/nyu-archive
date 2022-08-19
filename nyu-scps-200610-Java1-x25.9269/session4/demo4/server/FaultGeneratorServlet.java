import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.Detail;
import javax.xml.soap.DetailEntry;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeader;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;

import org.apache.log4j.Logger;

public class FaultGeneratorServlet extends HttpServlet{

	private static final Logger logger = Logger.getLogger(FaultGeneratorServlet.class);

    private static MessageFactory msgFactory = null;
    private static SOAPFactory soapFactory = null;
    
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        try {
            // Initialize it to the default.
            msgFactory = MessageFactory.newInstance();
            soapFactory = SOAPFactory.newInstance();
        } 
        catch (SOAPException ex) {
        	ex.printStackTrace();
            throw new ServletException("Unable to create factories"
                + ex.getMessage());
        }
    }

    public void doGet( HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        doPost(req,resp);
    }
    public void doPost( HttpServletRequest req, HttpServletResponse resp) throws ServletException{

	  String symbol=null;
      SOAPMessage reply = null;
        try {

            // Get the header of the request.
            MimeHeaders headers = getHeaders(req);

            // Get the body of the HTTP request.
            InputStream is = req.getInputStream();


            logger.info("Retrieving the request message...");
            // Now internalize the contents of a HTTP request and
            // create a SOAPMessage
            SOAPMessage requestMessage = msgFactory.createMessage(headers, is);

            logger.info("Retrieving the getStockQuote tag....");
            //find getStockQuote
            Name getStockQuote = soapFactory.createName("getStockQuote","p","http://www.quote.nyu.edu");
            Iterator iterator = requestMessage.getSOAPPart().getEnvelope().getBody().getChildElements(getStockQuote);
            SOAPBodyElement element   = (SOAPBodyElement)iterator.next();

            logger.info("Retrieving the StockSymbol tag...");
            //find StockSymbol.
            Name stockSymbol = soapFactory.createName("StockSymbol","q","http://www.quote.nyu.edu");
            Iterator iterator2 = element.getChildElements(stockSymbol);
            SOAPBodyElement element2   = (SOAPBodyElement)iterator2.next();
            symbol = element2.getValue();

            logger.info("Constructing the reply message...");
            // construct the reply.
            reply = msgFactory.createMessage();
            SOAPEnvelope envelope = reply.getSOAPPart().getEnvelope();

            // add some Namespaces requied for the message.
            envelope.addNamespaceDeclaration("xsi","http://www.w3.org/2001/XMLSchema-instance");
            envelope.addNamespaceDeclaration("xsd","http://www.w3.org/2001/XMLSchema");

            // Create a named tag
            Name getStockQuoteResponse = envelope.createName("getStockQuoteResponse","m","http://www.quote.nyu.edu");

            SOAPBodyElement bodyElement = envelope.getBody().addBodyElement(getStockQuoteResponse);

            // Create a named tag
            Name encodingStyle  = envelope.createName("encodingStyle","SOAP-ENV","http://schemas.xmlsoap.org/soap/envelope/");

            // Add the encodingStyle attribute to getQuote tag.
            bodyElement.addAttribute(encodingStyle,"http://schemas.xmlsoap.org/soap/encoding/");

            // Create another named tag
            Name getStockQuoteReturn = envelope.createName("getStockQuoteReturn");

            // Add as child element.
            SOAPElement bodySubElement = bodyElement.addChildElement(getStockQuoteReturn);
            
            // Create another named tag
            Name type = envelope.createName("type","xsi","http://www.w3.org/2001/XMLSchema-instance");
           
            // Add the type attribute
            bodySubElement.addAttribute(type,"xsd:string");

            // Add text
            bodySubElement.addTextNode("The last trading price of " + symbol + " is " +Math.round(Math.random()*100));

        } 
        catch (Exception ex) {
        	try{
        	logger.error("Exception", ex);
            logger.info("Constructing a Fault Message...");
        	reply = msgFactory.createMessage();
			SOAPFault fault = reply.getSOAPBody().addFault(); 
			Name faultName = soapFactory.createName("Client",
				"", SOAPConstants.URI_NS_SOAP_ENVELOPE);
			fault.setFaultCode(faultName);
			fault.setFaultString("Exception Occured: " + ex.toString());
			Detail detail = fault.addDetail();
			Name entryName = soapFactory.createName("Exception");
			ByteArrayOutputStream expectionByteArray = new ByteArrayOutputStream();
			ex.printStackTrace(new PrintStream(expectionByteArray));
			
			DetailEntry entry = detail.addDetailEntry(entryName);
			entry.addTextNode(expectionByteArray.toString());
        	}
        	catch(Exception e){
        		e.printStackTrace();
        	}
        }
        finally{
        	try{
        		if (reply != null) {
	
	                // Need to saveChanges since we're going to use the
	                // MimeHeaders to set HTTP response information. These
	                // MimeHeaders are generated as part of the save.
	
	                if (reply.saveRequired()) {
	                    reply.saveChanges();
	                }
	
	                resp.setStatus(HttpServletResponse.SC_OK);
	
	                putHeaders(reply.getMimeHeaders(), resp);
	
	                // Write out the message on the response stream.
	                OutputStream os = resp.getOutputStream();
	                reply.writeTo(os);
	
	                os.flush();
	
	            } 
	            else{
	                 resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
	            }
        	}
        	catch(Exception ex){
        		ex.printStackTrace();
        	}
        	
        }
    }

    static MimeHeaders getHeaders(HttpServletRequest req) {

    	MimeHeaders mimeHeaders = new MimeHeaders();
    	Enumeration httpHeaders = req.getHeaderNames();

    	System.out.println();
    	System.out.println("The following HTTP Headers were found in the request:");
    	while (httpHeaders.hasMoreElements()) {
            String headerName = (String) httpHeaders.nextElement();
            Enumeration headerValues = req.getHeaders(headerName);

            while (headerValues.hasMoreElements()){
                String headerValue = (String) headerValues.nextElement();
                mimeHeaders.addHeader(headerName, headerValue.trim());
                System.out.println("Header Name: " + headerName +" , Value: " + headerValue.trim());
            }
    	}

    	return mimeHeaders;
    }

    static void putHeaders(MimeHeaders headers, HttpServletResponse res) {

    	logger.info("The following MIME Headers were found in response:");
    	Iterator it = headers.getAllHeaders();
        while (it.hasNext()) {
            MimeHeader header = (MimeHeader)it.next();

            String[] values = headers.getHeader(header.getName());
            if (values.length == 1){
                res.setHeader(header.getName(), header.getValue());
                logger.info("Header Name: " + header.getName() +" , Value: " + header.getValue());
            }
            else 
            {
                StringBuffer concat = new StringBuffer();
                int i = 0;
                while (i < values.length) {
                    if (i != 0) {
                    concat.append(',');
                    }
                    concat.append(values[i++]);
                }

                res.setHeader(header.getName(),
                concat.toString());
            }
        }
    }

}

