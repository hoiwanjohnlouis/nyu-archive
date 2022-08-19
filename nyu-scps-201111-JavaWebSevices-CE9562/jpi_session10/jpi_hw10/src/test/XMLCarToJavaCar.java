package test;

import edu.nyu.scps.jws.carmanagement.AbstractVehicleType;
import edu.nyu.scps.jws.carmanagement.CarType;
import edu.nyu.scps.jws.carmanagement.TriStateType;
import edu.nyu.scps.jws.carmanagement.ObjectFactory;
import edu.nyu.scps.jws.name.ExtendedNameType;
import edu.nyu.scps.jws.name.NameType;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

public class XMLCarToJavaCar {

    private static final Logger logger = Logger.getLogger(XMLCarToJavaCar.class);

    public static void main( String[] args ) {

    	logger.debug("Unmarshaller starts...");

        try {

            // create a JAXBContext capable of handling classes generated into
            // the car package
            logger.debug("Creating JAXB Context...");
            JAXBContext context = JAXBContext.newInstance("edu.nyu.scps.jws.carmanagement");

            // create an Unmarshaller
            logger.debug("..creating Unmarshaller");
            Unmarshaller thisUnmarshaller = context.createUnmarshaller();

            // what's the XSD schema file to read/use
            logger.debug("..setting schemaFile");
            File xsdFile = new File("./src/Car.xsd");

            // set the schema
            logger.debug("..setting schemaFactory");
            SchemaFactory schemaFactory = SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema thisSchema = schemaFactory.newSchema(xsdFile);

            //prepare for validation: link Unmarshaller to schema
            logger.debug("..tie Unmarshaller with Schema");
            thisUnmarshaller.setSchema(thisSchema);

            // what's the XML file to process or unmarshall
            logger.debug("..setting XML file to process");
            File xmlFile = new File("./src/hw-car-original.xml");

            // unmarshal an car instance document into a tree of Java content
            // objects composed of classes from the edu.nyu.scps.jws.carmanagement package.
            logger.debug("..unmarshal XML file using schema");
            JAXBElement<CarType> i = (JAXBElement<CarType>) thisUnmarshaller.unmarshal(xmlFile);

            // The XML is unmarshalled
            logger.debug("..extract the unmarshalled data");
            CarType oneCar = i.getValue();

            logger.info("Unmarshalled data...");
            logger.info("CarType.Vin: " + oneCar.getVIN());

            logger.info("CarType.Color: " + oneCar.getColor());
            logger.info("CarType.Make: " + oneCar.getMake());
            logger.info("CarType.Model: " + oneCar.getModel());
            
            List<ExtendedNameType> owners = oneCar.getOwner();
            Iterator<ExtendedNameType> x = owners.iterator();
        	int j = 0;
            while(x.hasNext()) {
            	j++;
            	ExtendedNameType name = x.next();
            	logger.info("CarType.Owner.ExtendedNameType.NameId" + j + ": " + name.getId());
            	logger.info("CarType.Owner.ExtendedNameType.FirstName" + j + ": " + name.getFirstName());
            	logger.info("CarType.Owner.ExtendedNameType.LastName" + j + ": " + name.getLastName());
            	logger.info("CarType.Owner.ExtendedNameType.MiddleName" + j + ": " + name.getMiddleName());
            	
            	// take care of optional fields
            	if ((null != name.getNickName()) && (name.getNickName().length() > 0)) {
                	logger.info("CarType.Owner.ExtendedNameType.NickName" + j + ": " + name.getNickName());
            	}
            	if ((null != name.getMaidenName()) && (name.getMaidenName().length() > 0)) {
            		logger.info("CarType.Owner.ExtendedNameType.MaidenName" + j + ": " + name.getMaidenName());
            	}
            }
            logger.info("CarType.Type: " + oneCar.getType());
            logger.info("CarType.Year: " + oneCar.getYear());
            logger.info("CarType.PlateNumber: " + oneCar.getPlateNumber());
            logger.info("CarType.RegistrationNumwber: " + oneCar.getRegistrationNumber());
            logger.info("CarType.State: " + oneCar.getState());
            logger.info("CarType.Price: " + oneCar.getPrice());

            logger.info("Unmarshalled data complete.");

        } catch( JAXBException je ) {
            je.printStackTrace();
        }
        catch(SAXException je ) {
            je.printStackTrace();
        }

        logger.debug("Unmarshaller ends...");

    }
}
