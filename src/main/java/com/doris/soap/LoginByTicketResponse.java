package com.doris.soap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name="LoginByTicketResponse", namespace = Namespaces.TEM_URI)
public class LoginByTicketResponse {

	
	private String LoginByTicketResult;

	public String getLoginByTicketResult() {
		return LoginByTicketResult;
	}

	@XmlElement(name="LoginByTicketResult", namespace=Namespaces.TEM_URI)
	public void setLoginByTicketResult(String loginByTicketResult) {
		LoginByTicketResult = loginByTicketResult;
	}
}
