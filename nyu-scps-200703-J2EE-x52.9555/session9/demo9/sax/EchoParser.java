// 9B
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
public class EchoParser{
	public static void main(String[] args){
		if (args.length==0){
			System.out.println("Usage: EchoParser <XML Document Name>");
			System.exit(0);
		}
		try{
			String vendorParserClass = "org.apache.xerces.parsers.SAXParser";
			XMLReader reader = XMLReaderFactory.createXMLReader(vendorParserClass);
			reader.setContentHandler(new EchoDocHandler());
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
}