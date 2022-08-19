import java.io.ByteArrayOutputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.dom.DOMSource;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;

public class EnvelopeSender{
	
	private static final Logger logger = Logger.getLogger(EnvelopeSender.class);

    public static void main(String[] args){
        String to ="http://localhost:8080/servlet/StockQuoteProviderServlet";
        
    	SOAPConnection con =null;
		SOAPConnectionFactory scf = null;
		MessageFactory messageFactory = null;
		SOAPMessage message = null;
	    DocumentBuilderFactory dbFactory= null;
	    DocumentBuilder builder =null;

        try {

            logger.debug("Creating DOM Tree from the file....");
            String fileName = "request.env";
            dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setNamespaceAware(true);
            builder = dbFactory.newDocumentBuilder();
            Document document = builder.parse(fileName);
            DOMSource domSource = new DOMSource(document);  

            URL urlEndpoint = new URL(to);
            
            logger.debug("Creating connection....");
            // create a connection from the factory.	
            scf = SOAPConnectionFactory.newInstance();
            con = scf.createConnection();

            logger.debug("Creating message...");
	    	//create a message from the factory.
            messageFactory = MessageFactory.newInstance();
            message = messageFactory.createMessage();

            logger.debug("Setting SOAPAction MIME Header..");
            //add the SOAPAction HTTP header.
            message.getMimeHeaders().setHeader("SOAPAction","");

            logger.debug("Populating envelope from file..");
            // Message creation takes care of creating the SOAPPart - a
            // required part of the message as per the SOAP 1.1
            // soapPartecification.
            SOAPPart soapPart = message.getSOAPPart();
            soapPart.setContent(domSource); 
            
	    	// write out the message for display
	    	ByteArrayOutputStream requestByteArray = new ByteArrayOutputStream();
            message.writeTo(requestByteArray );
	    	logger.debug("Request:");
	    	logger.debug(requestByteArray.toString());
	
            logger.debug("Calling the service....");
            // Send the message to the provider using the connection.
            SOAPMessage reply = con.call(message, urlEndpoint);

            if (reply != null) {

            	logger.debug("Got reply....");
				//write out the reply message for display.
                ByteArrayOutputStream replyByteArray = new ByteArrayOutputStream();
                reply.writeTo(replyByteArray);
	        	logger.debug("Response:");
	        	logger.debug(replyByteArray.toString());
            }
       } 
        catch(Exception e) {
            logger.error("Exception",e);
        }
    }
}
