// Code 9H
import java.io.IOException;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
public class TreeModifier{
	public static void main(String[] args){
		try{
			DOMParser parser = new DOMParser();
			parser.parse("movielist.xml");
			Document doc = parser.getDocument();

			System.out.println("Document Before Changes:");
			DOMTreeWalker2.walk(doc);
			System.out.println();

			NodeList titles= doc.getElementsByTagName("Title");
			NodeList movies= doc.getElementsByTagName("Movie");
			Text textNode1= (Text) titles.item(0).getFirstChild();
			textNode1.setData("Speed");

			Element price1 = doc.createElement("Price");
			Text	priceText1 = doc.createTextNode("12.99");
			price1.appendChild(priceText1);
			movies.item(0).appendChild(price1);
		
			Element price2 = doc.createElement("Price");
			Text	priceText2 = doc.createTextNode("10.99");
			price2.appendChild(priceText2);
			movies.item(1).appendChild(price2);

			System.out.println("Document After Changes:");
			DOMTreeWalker2.walk(doc);

		}
		catch(SAXException e){
			System.out.println(e);
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
}