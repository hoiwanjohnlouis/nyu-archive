// Code 9G
import org.apache.xerces.dom.DOMImplementationImpl;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
public class NewTreeBuilder{
	public static void main(String[] args){
		DOMImplementation domImpl = new DOMImplementationImpl();
		Document doc = domImpl.createDocument(null,"MovieList",null);
		Element root = doc.getDocumentElement();
		root.setAttribute("Count","2");

		Element movie1 = doc.createElement("Movie");
		Element title1 = doc.createElement("Title");
		Text	titleText1 = doc.createTextNode("Gods must be crazy");
		title1.appendChild(titleText1);
		movie1.appendChild(title1);
		
		Element movie2 = doc.createElement("Movie");
		Element title2 = doc.createElement("Title");
		Text	titleText2 = doc.createTextNode("Forget Paris");
		title2.appendChild(titleText2);
		movie2.appendChild(title2);

		root.appendChild(movie1);
		root.appendChild(movie2);
		
		DOMTreeWalker2.walk(doc);
	}
}