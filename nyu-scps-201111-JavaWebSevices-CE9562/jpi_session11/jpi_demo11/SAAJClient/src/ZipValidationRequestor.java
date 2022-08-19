import java.io.ByteArrayOutputStream;
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
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.apache.log4j.Logger;

public class ZipValidationRequestor{

	private static final Logger logger = Logger.getLogger(ZipValidationRequestor.class);

    public static void main(String[] args){
        String to ="http://www.webservicemart.com/uszip.asmx";
    	SOAPConnection con =null;
		SOAPConnectionFactory scf = null;
		MessageFactory messageFactory = null;
		SOAPMessage message = null;
		SOAPFactory soapFactory = null;
		ByteArrayOutputStream requestByteArray = null;
        ByteArrayOutputStream replyByteArray = null;
        try {

            URL urlEndpoint = new URL(to);

            logger.debug("Creating message ...");

            //create a soap factory
            soapFactory = SOAPFactory.newInstance();

            //create a message from the factory.
            messageFactory = MessageFactory.newInstance();
            message = messageFactory.createMessage();
          
            requestByteArray = new ByteArrayOutputStream();
            message.writeTo(requestByteArray);
        	logger.debug("Request message after initial construction:");
        	logger.debug(requestByteArray.toString());
 
            // add the SOAPAction HTTP header.
            message.getMimeHeaders().setHeader("SOAPAction","http://webservicemart.com/ws/ValidateZip");

            // get the a soap body from the message.
            SOAPBody body = message.getSOAPBody();
            
            // Create a named tag
            Name validateZip  = soapFactory.createName("ValidateZip","x","http://webservicemart.com/ws/");
           
            // Add a soap body element to the soap body
            SOAPBodyElement bodyElement = body.addBodyElement(validateZip);

            // Create another named tag
            Name zipCode = soapFactory.createName("ZipCode","x","http://webservicemart.com/ws/");

            // Add as child element and text to it.
            bodyElement.addChildElement(zipCode).addTextNode("11703");

            
	    	// write out the populated message for display
	    	requestByteArray = new ByteArrayOutputStream();
            message.writeTo(requestByteArray );
	    	logger.debug("Request SOAP Message:");
	    	logger.debug(requestByteArray.toString());
	
	    	// create a connection from the factory.	
            scf = SOAPConnectionFactory.newInstance();
            con = scf.createConnection();

            // Send the message to the provider using the connection.
            SOAPMessage reply = con.call(message, urlEndpoint);

            if (reply != null) {
            	
                Name validateZipResponse  = soapFactory.createName("ValidateZipResponse","x","http://webservicemart.com/ws/");
            	SOAPBody replyBody = reply.getSOAPBody();
            	SOAPBodyElement replyBodyElement = (SOAPBodyElement) replyBody.getChildElements(validateZipResponse).next();

            	Name validateZipResult  = soapFactory.createName("ValidateZipResult","x","http://webservicemart.com/ws/");
            	SOAPBodyElement replyBodySubElement = (SOAPBodyElement) replyBodyElement.getChildElements(validateZipResult).next();
            	
            	String replyValue = replyBodySubElement.getValue();
	        	logger.info("Here is the reply: " + replyValue);
            	
				//write out the reply message for display.
                replyByteArray = new ByteArrayOutputStream();
                reply.writeTo(replyByteArray);
	        	logger.debug("Response SOAP Message from the service:");
	        	logger.debug(replyByteArray.toString());
            }
		} 
		catch(MalformedURLException e) {
			 logger.error("Exception", e);
		}
		catch(IOException e) {
			 logger.error("Exception", e);
		}
		catch(SOAPException e) {
			 logger.error("Exception", e);
		}
    }
}
