/**
 * 
 */
package com.doris.soap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author doris
 * 
 */
@XmlRootElement(name = "Envelope", namespace = Namespaces.SOAP_URI)
public class Envelope {

	private Header header;

	
	private Body body;

	@XmlElement(name="Header", namespace= Namespaces.SOAP_URI)
	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	@XmlElement(name = "Body", namespace = Namespaces.SOAP_URI)
	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

}
