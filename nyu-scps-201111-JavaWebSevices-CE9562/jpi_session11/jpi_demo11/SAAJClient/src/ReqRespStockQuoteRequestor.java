import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.apache.log4j.Logger;

public class ReqRespStockQuoteRequestor{

	private static final Logger logger = Logger.getLogger(ReqRespStockQuoteRequestor.class);

    public static void main(String[] args){
        String to ="http://localhost:8080/JAXMDemo/ReqRespJAXMServlet";
        

    	SOAPConnection con =null;
		SOAPConnectionFactory scf = null;
		MessageFactory messageFactory = null;
		SOAPMessage message = null;

        try {

            URL urlEndpoint = new URL(to);


            logger.debug("Creating message....");
	    	//create a message from the factory.
            messageFactory = MessageFactory.newInstance();
            message = messageFactory.createMessage();

            logger.debug("Populating message....");
            //add the SOAPAction HTTP header.
            message.getMimeHeaders().setHeader("SOAPAction","");

            // Message creation takes care of creating the SOAPPart - a
            // required part of the message as per the SOAP 1.1
            // soapPartecification.
            SOAPPart soapPart = message.getSOAPPart();

            // Retrieve the envelope from the soap part to start building
            // the soap message.
            SOAPEnvelope envelope = soapPart.getEnvelope();
            
            // add some Namespaces requied for the message.
            envelope.addNamespaceDeclaration("xsi","http://www.w3.org/2001/XMLSchema-instance");
            envelope.addNamespaceDeclaration("xsd","http://www.w3.org/2001/XMLSchema");

            // get the a soap body from the envelope.
            SOAPBody body = envelope.getBody();
            
            // Create a named tag
            Name getStockQuote = envelope.createName("getStockQuote","m","http://www.quote.nyu.edu");
           
            // Add a soap body element to the soap body
            SOAPBodyElement bodyElement = body.addBodyElement(getStockQuote);

            // Create a named tag
            Name encodingStyle  = envelope.createName("encodingStyle","SOAP-ENV","http://schemas.xmlsoap.org/soap/envelope/");

            // Add the encodingStyle attribute to getQuote tag.
            bodyElement.addAttribute(encodingStyle,"http://schemas.xmlsoap.org/soap/encoding/");

            // Create another named tag
            Name stockSymbol = envelope.createName("StockSymbol","m","http://www.quote.nyu.edu");

            // Add as child element
            SOAPElement bodySubElement = bodyElement.addChildElement(stockSymbol);
            
            // Create another named tag
            Name type = envelope.createName("type","xsi","http://www.w3.org/2001/XMLSchema-instance");
           
            // Add the type attribute to HTMLformat tag.
            bodySubElement.addAttribute(type,"xsd:string");

            // Add the symbol
			bodySubElement.addTextNode("MSFT");

            
            logger.debug("Prining message....");
	    	// write out the message for display
	    	ByteArrayOutputStream requestByteArray = new ByteArrayOutputStream();
            message.writeTo(requestByteArray );
	    	logger.debug("Request:");
	    	logger.debug(requestByteArray.toString());
	
	    	// create a connection from the factory.	
            scf = SOAPConnectionFactory.newInstance();
            con = scf.createConnection();

            // Send the message to the provider using the connection.
            SOAPMessage reply = con.call(message, urlEndpoint);

            if (reply != null) {
		
				//write out the reply message for display.
                ByteArrayOutputStream replyByteArray = new ByteArrayOutputStream();
                reply.writeTo(replyByteArray);
	        	logger.debug("Response:");
	        	logger.debug(replyByteArray.toString());
            }
		}
		catch(MalformedURLException e) {
			logger.debug("Exception",e);
		}
		catch(IOException e) {
			logger.debug("Exception",e);
		}
		catch(SOAPException e) {
			logger.debug("Exception",e);
		}
    }
}
