//Code 9C
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
public class Converter extends DefaultHandler{
	private Locator docLocator;
	public static void main(String[] args){
		if (args.length==0){
			System.out.println("Usage: Converter <XML Document Name>");
			System.exit(0);
		}
		try{
			String vendorParserClass = "org.apache.xerces.parsers.SAXParser";
			XMLReader reader = XMLReaderFactory.createXMLReader(vendorParserClass);
			
			// validate 
			reader.setFeature("http://xml.org/sax/features/validation", true);
			
			// add the content handler
			reader.setContentHandler(new Converter());
			File file = new File(args[0]);
			FileReader input = new FileReader(file);
			InputSource source = new InputSource(input);
			source.setSystemId(args[0]);
			reader.parse(source);
		}
		catch(SAXException e){
			System.out.println(e);
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
	public void setDocumentLocator(Locator locator){
		docLocator=locator;
	}

	public void startDocument() throws SAXException{
		System.out.println("<HTML>");
	}
	public void endDocument() throws SAXException{
		System.out.println("</HTML>");
	}
	public void startElement(String uri,String localName,
		String qName,Attributes attributes) throws SAXException{

		// ignore document element
		if (qName.equals("document")){
			return;
		}
		// ignore authors element
		if (qName.equals("authors")){
			return;
		}

		// ignore person element
		if (qName.equals("person")){
			return;
		}
		// change color and font when s1 element is seen.
		if (qName.equals("header")){
			System.out.print("<HEAD>");
			return;
		}

		// change color and font when s1 element is seen.
		if (qName.equals("s1")){
			System.out.print("<B><FONT  color=DarkBlue size='+1'>" + attributes.getValue(0)+ "</FONT></B>");
			return;
		}

		// change figure element to <IMG> tag
		if (qName.equals("figure")){
			System.out.print("<IMG");
		}
		else{
			System.out.print("<" + qName);
		}
		for (int i=0; i < attributes.getLength(); i++){
			String s = " " + attributes.getQName(i) + "=" + attributes.getValue(i);
			System.out.print(s);
		}
		System.out.print(">");

		// add an extra paragraph when figure tag is encountered.
		if (qName.equals("figure")){
			System.out.println("<p>");
		}
		else{
			System.out.println();
		}
	}

	// if character data - just print it.
	public void characters(char[] ch,int start,int length) throws SAXException{
		String s = new String(ch,start,length);
		if (s.trim().length()>0){
			System.out.print(s.trim());
		}
	}

	// end of element
	public void endElement(String uri,String localName,
		String qName) throws SAXException{

		// if end of s1 - ignone.
		if (qName.equals("s1")){
			return;
		}
	
		// if end of document - ignore.
		if (qName.equals("document")){
			return;
		}
		
		// if end of authors - ignore.
		if (qName.equals("authors")){
			return;
		}

		if (qName.equals("header")){
			System.out.print("</HEAD>");
			return;
		}

		// if end of persons - ignore.
		if (qName.equals("person")){
			return;
		}

		// if end of figure - print </IMG>
		if (qName.equals("figure")){
			System.out.print("</IMG>");
		}
		// otherwise - just close the tag
		else{
			System.out.println("</" + qName + ">");
		}
	}
}