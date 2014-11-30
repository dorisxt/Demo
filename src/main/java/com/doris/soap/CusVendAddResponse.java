package com.doris.soap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="CusVen_AddResponse", namespace= Namespaces.TEM_URI)
public class CusVendAddResponse {

	private ResultModeOfString cusVenAddResult;

	public ResultModeOfString getCusVenAddResult() {
		return cusVenAddResult;
	}

	@XmlElement(name="CusVen_AddResult", namespace= Namespaces.TEM_URI)
	public void setCusVenAddResult(ResultModeOfString cusVenAddResult) {
		this.cusVenAddResult = cusVenAddResult;
	}

}
