//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.01.12 at 10:48:31 AM EST 
//


package edu.nyu.scps.jws.name;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.nyu.scps.jws.name package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Name_QNAME = new QName("http://www.scps.nyu.edu/jws/Name", "name");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.nyu.scps.jws.name
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ExtendedNameType }
     * 
     */
    public ExtendedNameType createExtendedNameType() {
        return new ExtendedNameType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExtendedNameType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.scps.nyu.edu/jws/Name", name = "name")
    public JAXBElement<ExtendedNameType> createName(ExtendedNameType value) {
        return new JAXBElement<ExtendedNameType>(_Name_QNAME, ExtendedNameType.class, null, value);
    }

}
