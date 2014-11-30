package com.doris.soap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "LoginByTicket",namespace = Namespaces.TEM_URI)
public class LoginByTicket{

	private String wsUser;

	private String wsPwd;

	public String getWsUser() {
		return wsUser;
	}

	@XmlElement(name = "wsUser", namespace = Namespaces.TEM_URI)
	public void setWsUser(String wsUser) {
		this.wsUser = wsUser;
	}

	public String getWsPwd() {
		return wsPwd;
	}

	@XmlElement(name = "wsPwd", namespace = Namespaces.TEM_URI)
	public void setWsPwd(String wsPwd) {
		this.wsPwd = wsPwd;
	}

}
