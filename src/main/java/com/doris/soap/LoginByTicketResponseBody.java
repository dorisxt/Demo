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
@XmlRootElement(name="Body", namespace=Namespaces.SOAP_URI)
public class LoginByTicketResponseBody {
	
	private  LoginByTicketResponse loginByTicketResponse;

	public LoginByTicketResponse getLoginByTicketResponse() {
		return loginByTicketResponse;
	}

	@XmlElement(name="LoginByTicketResponse" ,namespace =Namespaces.TEM_URI)
	public void setLoginByTicketResponse(LoginByTicketResponse loginByTicketResponse) {
		this.loginByTicketResponse = loginByTicketResponse;
	}

	 
    
	

}
