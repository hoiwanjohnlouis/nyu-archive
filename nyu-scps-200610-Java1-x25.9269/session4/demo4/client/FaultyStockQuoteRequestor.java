import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.Iterator;

import javax.xml.soap.Detail;
import javax.xml.soap.DetailEntry;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.apache.log4j.Logger;

public class FaultyStockQuoteRequestor{
	private static final Logger logger = Logger.getLogger(FaultyStockQuoteRequestor.class);

    public static void main(String[] args){
        String to ="http://localhost:8080/servlet/FaultGeneratorServlet";
        
        if (args.length < 1) {
          logger.error("Usage: java " + FaultyStockQuoteRequestor.class.getName () +
                              " <symbol>");
          System.exit (1);
        }

    	SOAPConnection con =null;
		SOAPConnectionFactory scf = null;
		MessageFactory messageFactory = null;
		SOAPMessage message = null;

        try {

            URL urlEndpoint = new URL(to);

            logger.debug("Constructing message...");
	    	// create a connection from the factory.	
            scf = SOAPConnectionFactory.newInstance();
            con = scf.createConnection();

	    	//create a message from the factory.
            messageFactory = MessageFactory.newInstance();
            message = messageFactory.createMessage();

            logger.debug("Setting SOAPAction MIME Header...");
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
            
            logger.debug("Putting getStockQuote tag...");
            // Create a named tag
            Name getStockQuote = envelope.createName("getStockQuote","m","http://www.quote.nyu.edu");
           
            // Add a soap body element to the soap body
            SOAPBodyElement bodyElement = body.addBodyElement(getStockQuote);

            // Create a named tag
            Name encodingStyle  = envelope.createName("encodingStyle","SOAP-ENV","http://schemas.xmlsoap.org/soap/envelope/");

            // Add the encodingStyle attribute to getQuote tag.
            bodyElement.addAttribute(encodingStyle,"http://schemas.xmlsoap.org/soap/encoding/");

            logger.debug("Putting ABCD tag...");
            // Create another named tag
            Name wrongTag = envelope.createName("ABCD","m","http://www.quote.nyu.edu");

            // Add as child element
            SOAPElement bodySubElement = bodyElement.addChildElement(wrongTag);
            
            // Create another named tag
            Name type = envelope.createName("type","xsi","http://www.w3.org/2001/XMLSchema-instance");
           
            // Add the type attribute to HTMLformat tag.
            bodySubElement.addAttribute(type,"xsd:string");

            // Add the symbol
			bodySubElement.addTextNode(args[0]);

            
	    	// write out the message for display
	    	ByteArrayOutputStream requestByteArray = new ByteArrayOutputStream();
            message.writeTo(requestByteArray );
	    	logger.debug("Request:");
	    	logger.debug(requestByteArray.toString());
	
            // Send the message to the provider using the connection.
            SOAPMessage reply = con.call(message, urlEndpoint);

            if (reply != null) {
		
				//write out the reply message for display.
                ByteArrayOutputStream replyByteArray = new ByteArrayOutputStream();
                reply.writeTo(replyByteArray);
	        	logger.debug("Response:");
	        	logger.debug(replyByteArray.toString());
				SOAPBody newBody = reply.getSOAPBody();
				if (newBody.hasFault()) {
					SOAPFault newFault = newBody.getFault();
					Name code = newFault.getFaultCodeAsName();
					String string = newFault.getFaultString();
					String actor = newFault.getFaultActor(); 
					logger.debug("SOAP fault contains: ");
					logger.debug("  Fault code = " + code.getQualifiedName());
					logger.debug("  Fault string = " + string);
	
					if ( actor != null ) {
						logger.debug("  Fault actor = " + actor);
					} 
					Detail newDetail = newFault.getDetail();
					if ( newDetail != null) {
						Iterator entries = newDetail.getDetailEntries();
						while ( entries.hasNext() ) {
							DetailEntry newEntry = 
								(DetailEntry)entries.next();
							String value = newEntry.getValue();
							logger.debug("  Detail entry:");
							logger.debug(value);
						}
					} 
				}
            }
       } 
        catch(Exception e) {
        	logger.error("Exception", e);
        }
    }
}
