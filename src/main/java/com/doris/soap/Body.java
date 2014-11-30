package com.doris.soap;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.dom4j.Namespace;

//@XmlRootElement(name="Body", namespace=Namespaces.SOAP_URI)
@XmlSeeAlso({LoginByTicketBody.class})
public abstract class Body {
	
	public abstract String getBodyType();
	
	public Namespace getInstanceNameSpace(){
		return new Namespace("tt","http://www.w3.org/2001/XMLSchema-instance");
	}
	
}
