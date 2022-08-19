// Code 9D
import java.io.IOException;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
public class DOMTest{
	public static void main(String[] args){
		if (args.length==0){
			System.out.println("Usage: DOMTest <XML Document Name>");
			System.exit(0);
		}
		try{
			DOMParser parser = new DOMParser();
			parser.parse(args[0]);
			Document doc = parser.getDocument();
			System.out.println(doc.getNodeName());
		}
		catch(SAXException e){
			System.out.println(e);
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
}