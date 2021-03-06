package com.swayam.demo.xml;

import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.swayam.demo.xml.jaxb.SimpleMapEntry;

public class PlainJaxbSerializer implements XmlSerializer {

    private static final Logger LOG = LoggerFactory.getLogger(PlainJaxbSerializer.class);

    @Override
    public void serialize(Object object, OutputStream outputStream) {
	JAXBContext jaxbContext;
	try {
	    jaxbContext = JAXBContext.newInstance(EmployeeGroups.class, SimpleMapEntry.class);
	} catch (JAXBException e) {
	    throw new RuntimeException(e);
	}

	Marshaller marshaller;
	try {
	    marshaller = jaxbContext.createMarshaller();
	} catch (JAXBException e) {
	    throw new RuntimeException(e);
	}

	// for formatted xml
	try {
	    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	} catch (PropertyException e) {
	    LOG.warn("Invalid property", e);
	}

	Result xmlResultCapturer = new StreamResult(outputStream);
	try {
	    marshaller.marshal(object, xmlResultCapturer);
	} catch (Exception e) {
	    LOG.error("could not convert rmi output to xml", e);
	}
    }

}
