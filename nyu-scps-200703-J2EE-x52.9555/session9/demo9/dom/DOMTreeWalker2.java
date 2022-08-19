//Code 9F
import java.io.IOException;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
public class DOMTreeWalker2{

	public static void main(String[] args){
		if (args.length==0){
			System.out.println("Usage: DOMTreeWalker2 <XML Document Name>");
			System.exit(0);
		}
		try{
			DOMParser parser = new DOMParser();
			parser.parse(args[0]);
			Document doc = parser.getDocument();
			walk(doc);
		}
		catch(SAXException e){
			System.out.println(e);
		}
		catch(IOException e){
			System.out.println(e);
		}
	}


	public static void walk(Node node){

		switch (node.getNodeType()){

		case Node.DOCUMENT_NODE:
			System.out.println("DOCUMENT_NODE");
			break;
		case Node.ELEMENT_NODE:
			System.out.print("ELEMENT_NODE: <");
			System.out.print(((Element) node).getTagName() + ">");
			System.out.println(" Parent: " + node.getParentNode().getNodeName());

			if (node.hasAttributes()){
				NamedNodeMap attributes= node.getAttributes();
				for (int i=0; i < attributes.getLength(); i++){
					walk(attributes.item(i));
				}
			}
			break;
		case Node.ATTRIBUTE_NODE:
			System.out.print("ATTRIBUTE_NODE: '");
			System.out.print(((Attr)node).getName() + "'");
			System.out.println(" Value: " + ((Attr)node).getValue());
			System.out.println(" Parent: " + ((Attr) node).getOwnerElement().getNodeName());
			break;
		case Node.TEXT_NODE:
			System.out.print("TEXT_NODE: ");
			System.out.print("\"" + ((Text) node).getData() + "\"");
			System.out.println(" Parent: " + node.getParentNode().getNodeName());
			break;
		case Node.CDATA_SECTION_NODE:
			System.out.println("CDATA_SECTION_NODE");
			break;
		case Node.COMMENT_NODE:
			System.out.println("COMMENT_NODE");
			break;
		case Node.DOCUMENT_FRAGMENT_NODE:
			System.out.println("DOCUMENT_FRAGMENT_NODE");
			break;
		case Node.ENTITY_NODE:
			System.out.println("ENTITY_NODE");
			break;
		case Node.ENTITY_REFERENCE_NODE:
			System.out.println("ENTITY_REFERENCE_NODE");
			break;
		case Node.NOTATION_NODE:
			System.out.println("NOTATION_NODE");
			break;
		case Node.PROCESSING_INSTRUCTION_NODE:
			System.out.print("PROCESSING_INSTRUCTION_NODE ");
			break;
		case Node.DOCUMENT_TYPE_NODE:
			System.out.println("DOCUMENT_TYPE_NODE");
			break;
		}

		NodeList children = node.getChildNodes();
		if (children != null){
			for (int i=0; i<children.getLength(); i++){
				walk(children.item(i));
			}
		}
	}
}
