package test;

import edu.nyu.scps.jws.carmanagement.AbstractVehicleType;
import edu.nyu.scps.jws.carmanagement.CarType;
import edu.nyu.scps.jws.carmanagement.TriStateType;
import edu.nyu.scps.jws.carmanagement.ObjectFactory;
import edu.nyu.scps.jws.name.ExtendedNameType;
import edu.nyu.scps.jws.name.NameType;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

public class JavaCarToXMLCar {

    private static final Logger logger = Logger.getLogger(JavaCarToXMLCar.class);


    public static void main( String[] args ) {

    	logger.debug(JavaCarToXMLCar.class.getName() +  " starting...");

        try {
            
            // create an ObjectFactory instance.
            logger.debug("Creating Object Factory...");
            ObjectFactory objFactory = new ObjectFactory();
            logger.debug("Creating Object Factory complete.");

            // create an empty CarType
            logger.debug("Creating object empty CarType...");
            CarType carType1 = objFactory.createCarType();
            logger.debug("Creating object empty CarType complete");

            logger.debug("Populating a CarType Object...");
            carType1.setVIN("123456789");
            carType1.setColor("Red");
            carType1.setMake("Toyota");
            carType1.setModel("Prius");
            
            // insert owner1 to list
            ExtendedNameType owner1 = new ExtendedNameType();
            owner1.setId("1234");
            owner1.setFirstName("Frodo");
            owner1.setLastName("Baggins");
            owner1.setMiddleName("TheRingBearer");
            owner1.setNickName("Underhill");
            owner1.setMaidenName("BagShowRow");
            carType1.getOwner().add(owner1);
            
            carType1.setType("Hybrid");
            carType1.setYear(2009);
            carType1.setPlateNumber("XYZ 9875");
            carType1.setRegistrationNumber("314159I");
            carType1.setState(TriStateType.CT);
            carType1.setPrice(17000);
            
            // create the JAXBElement of car for marshaller
            // stuck on this for 1+ days due to overlooking the class note examples
            logger.debug("Creating JAXB Element of CarType...");
            JAXBElement<CarType> oneCar = objFactory.createCar(carType1);
            logger.debug("Creating JAXB Element of CarType complete.");

            logger.debug("Populating a CarType Object complete.");

            // create a JAXBContext
            logger.debug("create a JAXBContext...");
            String carmanagementPathName = "edu.nyu.scps.jws.carmanagement";
            JAXBContext jc = JAXBContext.newInstance( carmanagementPathName );
            logger.debug("create a JAXBContext complete [" + carmanagementPathName + "].");

            // prepare for validation
            logger.debug("Set schema from factory...");
            String schemaFileName = "./src/Car.xsd";
            File schemaFile = new File(schemaFileName);
            SchemaFactory sf = SchemaFactory.newInstance(
            		javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(schemaFile);
            logger.debug("Set schema from factory complete [" + schemaFileName + "].");

            logger.debug("Create marshaller...");
            Marshaller m = jc.createMarshaller();
            logger.debug("Create marshaller complete.");

            //turn on validation
            logger.debug("Set schema for marshaller...");
            m.setSchema(schema);
            logger.debug("Set schema for marshaller complete.");

            logger.debug("Setting property for formatted output...");
            m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
            
            logger.debug("Setting property for schema location...");
            m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, 
            		"http://www.scps.nyu.edu/jws/CarManagement ./Car.xsd");

            logger.info("Marshalling...");
            m.marshal( oneCar, System.out );
            logger.info("Marshalling complete...");

        } catch( JAXBException je ) {
            je.printStackTrace();
        }
        catch(SAXException je ) {
            je.printStackTrace();
        }

        logger.debug(JavaCarToXMLCar.class.getName() +  " ends...");
        
    }
}
