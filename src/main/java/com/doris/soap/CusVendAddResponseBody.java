package com.doris.soap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Body", namespace=Namespaces.SOAP_URI)
public class CusVendAddResponseBody {

	private CusVendAddResponse cusVenAddResponse;

	public CusVendAddResponse getCusVenAddResponse() {
		return cusVenAddResponse;
	}

	@XmlElement(name="CusVen_AddResponse", namespace= Namespaces.TEM_URI)
	public void setCusVenAddResponse(CusVendAddResponse cusVenAddResponse) {
		this.cusVenAddResponse = cusVenAddResponse;
	}

}
