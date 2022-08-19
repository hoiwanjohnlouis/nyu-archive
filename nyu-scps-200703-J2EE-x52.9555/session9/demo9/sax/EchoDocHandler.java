// code 9A
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
public class EchoDocHandler extends DefaultHandler{
	private Locator docLocator;

	// save the locator as private field.
	public void setDocumentLocator(Locator locator){
		docLocator=locator;
	}

	//startDocument event handler.
	public void startDocument() throws SAXException{
		System.out.println("startDocument");
	}

	//endDocument event handler.
	public void endDocument() throws SAXException{
		System.out.println("endDocument");
	}

	// start element event handler, attributes of the element is
	// passed to this event as a collection.
	public void startElement(String uri,String localName,
		String qName,Attributes attributes) throws SAXException{

		// print the element.
		System.out.println("startElement: " + qName +", localname: "+ localName +", uri: "+ uri);

		// print the attributes.
		if (attributes.getLength() > 0 ){
			System.out.println("\t" + "Attributes: ");
		}
		for (int i=0; i < attributes.getLength(); i++){

			System.out.println("Attribute: " + attributes.getQName(i) + ", Value: " + attributes.getValue(i) + ", localname: "+ attributes.getLocalName(i) +", uri: "+ attributes.getURI(i));
		}
	}

	// character data event handler.
	public void characters(char[] ch,int start,int length) throws SAXException{
		String s = new String(ch,start,length);
		System.out.println("Character Data: *" + s + "*");
	}

	// end element event handler.
	public void endElement(String uri,String localName,
		String qName) throws SAXException{
		System.out.println("endElement: " + qName);
	}

	// processing instruction event handler.	
	public void processingInstruction(String target, String data) throws SAXException{
		System.out.print("Processing Instruction:  ");
		System.out.println("target: " + target + ", data: " + data);

	}

	// start prefix mapping event handler.
	public void startPrefixMapping(String prefix,String uri) throws SAXException{
		System.out.print("startPrefixMapping:  ");
		System.out.println("prefix: " + prefix + ", uri: " + uri);
	}

	// end prefix mapping event handler.
	public void endPrefixMapping(String prefix) throws SAXException{
		System.out.print("endPrefixMapping:  ");
		System.out.println("prefix: " + prefix);
	}
}