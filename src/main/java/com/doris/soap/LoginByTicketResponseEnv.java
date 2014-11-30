package com.doris.soap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Envelope", namespace=Namespaces.SOAP_URI)
public class LoginByTicketResponseEnv {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Header header;

	private LoginByTicketResponseBody body;

	public Header getHeader() {
		return header;
	}

	@XmlElement(name="Header", namespace=Namespaces.SOAP_URI)
	public void setHeader(Header header) {
		this.header = header;
	}

	public LoginByTicketResponseBody getBody() {
		return body;
	}

	@XmlElement(name="Body", namespace=Namespaces.SOAP_URI)
	public void setBody(LoginByTicketResponseBody body) {
		this.body = body;
	}

}
