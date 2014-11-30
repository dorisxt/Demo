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
@XmlRootElement(name="Body",namespace=Namespaces.SOAP_URI)
public class LoginByTicketBody extends Body{
	
	
	private LoginByTicket loginByTicket;

	public LoginByTicket getLoginByTicket() {
		return loginByTicket;
	}

	@XmlElement(name = "LoginByTicket",namespace = Namespaces.TEM_URI)
	public void setLoginByTicket(LoginByTicket loginByTicket) {
		this.loginByTicket = loginByTicket;
	}

	@Override
	public String getBodyType() {
		return "loginByTicketBody";
	}
	
	

}
