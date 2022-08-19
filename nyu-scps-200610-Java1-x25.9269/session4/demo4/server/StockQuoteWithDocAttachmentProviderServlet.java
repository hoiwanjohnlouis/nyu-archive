import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Iterator;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeader;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPMessage;

import org.apache.log4j.Logger;

public class StockQuoteWithDocAttachmentProviderServlet extends HttpServlet{

    private static MessageFactory msgFactory = null;
    private static SOAPFactory soapFactory = null;
	private static final Logger logger = Logger.getLogger(StockQuoteWithDocAttachmentProviderServlet.class);
    
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

            logger.info("Got request message");
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

            logger.info("Adding doc attachment");
            FileDataSource datasource = new FileDataSource("\\attachment.doc");
            DataHandler dataHandler = new DataHandler(datasource);
            AttachmentPart attachment = reply.createAttachmentPart(); 
            attachment.setDataHandler(dataHandler);
            attachment.setContentId("Disclaimer.doc");
            reply.addAttachmentPart(attachment); 

            if (reply != null) {

            	ByteArrayOutputStream replyByteArray = new ByteArrayOutputStream();
                reply.writeTo(replyByteArray);
	        	logger.info("Response:");
	        	logger.info(replyByteArray.toString());

	        	// Need to saveChanges since we're going to use the
                // MimeHeaders to set HTTP response information. These
                // MimeHeaders are generated as part of the save.
				//write out the reply message for display.
                if (reply.saveRequired()) {
                    reply.saveChanges();
                }

                resp.setStatus(HttpServletResponse.SC_OK);

                putHeaders(reply.getMimeHeaders(), resp);

                logger.info("Sending reply");
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
        	logger.error("Exception", ex);
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

