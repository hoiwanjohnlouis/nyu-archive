import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.dom.DOMSource;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;

public class TextAttachmentReceiver{
	private static final Logger logger = Logger.getLogger(TextAttachmentReceiver.class);

    public static void main(String[] args){
        String to ="http://localhost:8080/servlet/StockQuoteWithTextAttachmentProviderServlet";
        
    	SOAPConnection con =null;
		SOAPConnectionFactory scf = null;
		MessageFactory messageFactory = null;
		SOAPMessage message = null;
	    DocumentBuilderFactory dbFactory= null;
	    DocumentBuilder builder =null;

        try {

            String fileName = "request.env";
            dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setNamespaceAware(true);
            builder = dbFactory.newDocumentBuilder();
            Document document = builder.parse(fileName);
            DOMSource domSource = new DOMSource(document);  

            URL urlEndpoint = new URL(to);
            
	    	// create a connection from the factory.	
            scf = SOAPConnectionFactory.newInstance();
            con = scf.createConnection();

	    	//create a message from the factory.
            messageFactory = MessageFactory.newInstance();
            message = messageFactory.createMessage();

            //add the SOAPAction HTTP header.
            message.getMimeHeaders().setHeader("SOAPAction","");

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
	
            // Send the message to the provider using the connection.
            SOAPMessage reply = con.call(message, urlEndpoint);

            if (reply != null) {
		
				//write out the reply message for display.
                ByteArrayOutputStream replyByteArray = new ByteArrayOutputStream();
                reply.writeTo(replyByteArray);
	        	logger.debug("Response:");
	        	logger.debug(replyByteArray.toString());
	        	
	        	logger.debug("Attachments:");
                Iterator iterator = reply.getAttachments();
                while (iterator.hasNext()) {
                    AttachmentPart attachment = (AttachmentPart)iterator.next();
                    String id = attachment.getContentId();
                    String type = attachment.getContentType();
                    if (type.equals("text/plain")){
                    	String content = attachment.getContent().toString();
                    	logger.debug("Text Attachment id: " + id);
                    	logger.debug("Text Attachment content: " + content );
                    }
                    else{
                    	logger.debug("Attachment id: " + id + " has content type: " + type );
                    }
                }
            }
          
        } 
        catch(Exception e) {
        	logger.error("Exception",e);
        }
    }
}
