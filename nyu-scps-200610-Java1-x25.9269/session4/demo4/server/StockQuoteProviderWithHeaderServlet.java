import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeader;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;

import org.apache.log4j.Logger;

public class StockQuoteProviderWithHeaderServlet extends HttpServlet{

	private static final Logger logger = Logger.getLogger(StockQuoteProviderWithHeaderServlet.class);

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
        	logger.error("Exception", ex);
            throw new ServletException("Unable to create factories"
                + ex.getMessage());
        }
    }

    public void doGet( HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        doPost(req,resp);
    }
    public void doPost( HttpServletRequest req, HttpServletResponse resp) throws ServletException{

	  String symbol=null;
        try {

            // Get the header of the request.
            MimeHeaders headers = getHeaders(req);

            // Get the body of the HTTP request.
            InputStream is = req.getInputStream();


            // Now internalize the contents of a HTTP request and
            // create a SOAPMessage
            SOAPMessage requestMessage = msgFactory.createMessage(headers, is);

            // get the header.
            SOAPHeader header = requestMessage.getSOAPPart().getEnvelope().getHeader();

            // go through all the headers.
        	logger.info("The following SOAP Headers and Attributes were found in request:");
            Iterator allHeaders = header.examineAllHeaderElements();
			while (allHeaders.hasNext()) {
				SOAPHeaderElement headerElement = (SOAPHeaderElement)allHeaders.next();
				Name headerName = headerElement.getElementName();
				String value = headerElement.getValue();
				logger.info("Header name is " + headerName.getLocalName());
				logger.info("Header prefix is " + headerName.getPrefix());
				logger.info("Header namespace is " + headerName.getURI());
				logger.info("Header value is " + value);
				
				// go through all the attibutes of the header.
				Iterator iterator = headerElement.getAllAttributes();
				while (iterator.hasNext()){
					 Name attributeName = (Name) iterator.next();
					logger.info("Attribute name is " + attributeName.getLocalName());
					logger.info("Attribute prefix is " + attributeName.getPrefix());
					logger.info("Attribute namespace is " + attributeName.getURI());
					logger.info("Attribute value is " + headerElement.getAttributeValue(attributeName));
				} 
			} 

			// go through all the headers and find the mustUnderstand header.
	    	logger.info("The following mustUnderstand SOAP Headers were found in request:");
	    	allHeaders = header.examineAllHeaderElements();
			while (allHeaders.hasNext()) {
				SOAPHeaderElement headerElement = (SOAPHeaderElement)allHeaders.next();
				if (headerElement.getMustUnderstand()){
					Name headerName = headerElement.getElementName();
					logger.info("Must Understand Header name is " + headerName.getLocalName());
					logger.info("Must Understand Header prefix is " + headerName.getPrefix());
					logger.info("Must UnderstandHeader namespace is " + headerName.getURI());
				}
			} 

			// extract a header with actor 'next'
	    	logger.info("The following 'next' Actor SOAP Headers were found in request:");
	    	
			Iterator actorHeaderElements =
				header.extractHeaderElements("http://schemas.xmlsoap.org/soap/actor/next"); 
			while (actorHeaderElements.hasNext()){
					SOAPHeaderElement headerElement = (SOAPHeaderElement)actorHeaderElements.next();
					Name headerName = headerElement.getElementName();
					logger.info("'next' Actor Header name is " + headerName.getLocalName());
					logger.info("'next' Actor Header prefix is " + headerName.getPrefix());
					logger.info("'next' Actor namespace is " + headerName.getURI());
				}

            
            //find getStockQuote
            Name getStockQuote = soapFactory.createName("getStockQuote","p","http://www.quote.nyu.edu");
            Iterator iterator = requestMessage.getSOAPPart().getEnvelope().getBody().getChildElements(getStockQuote);
            SOAPBodyElement element   = (SOAPBodyElement)iterator.next();

            //find StockSymbol.
            Name stockSymbol = soapFactory.createName("StockSymbol","q","http://www.quote.nyu.edu");
            Iterator iterator2 = element.getChildElements(stockSymbol);
            SOAPBodyElement element2   = (SOAPBodyElement)iterator2.next();
            symbol = element2.getValue();

            // construct the reply.
            SOAPMessage reply = null;
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
        catch (Exception ex) {
        	logger.error("Exception",ex);
            throw new ServletException("SAAJ failed "+ex.getMessage());
        }
    }

    static MimeHeaders getHeaders(HttpServletRequest req) {

    	MimeHeaders mimeHeaders = new MimeHeaders();
    	Enumeration httpHeaders = req.getHeaderNames();

    	while (httpHeaders.hasMoreElements()) {
            String headerName = (String) httpHeaders.nextElement();
            Enumeration headerValues = req.getHeaders(headerName);

            while (headerValues.hasMoreElements()){
                String headerValue = (String) headerValues.nextElement();
                mimeHeaders.addHeader(headerName, headerValue.trim());
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

