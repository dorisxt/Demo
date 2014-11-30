package com.doris.soap;

import javax.xml.soap.SOAPException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.QName;

public class JxabDemo {

	/**
	 * @param args
	 * @throws SOAPException 
	 * @throws DocumentException 
	 */
	public static void main(String[] args) throws SOAPException, DocumentException{
		Envelope envelope = new Envelope();
		Header header = new Header();
		LoginByTicketBody body = new LoginByTicketBody();
		LoginByTicket loginByTicket = new LoginByTicket();
		loginByTicket.setWsUser("");
		loginByTicket.setWsPwd("");
		body.setLoginByTicket(loginByTicket);
		envelope.setHeader(header);
		envelope.setBody(body);
		String soapxml1 = JaxbUtils.toXml(envelope, "UTF-8");
		System.out.println(soapxml1);
		//xsi:type='loginByTicketBody' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'
		String soapxml = "<soap:Envelope  xmlns:soap='http://schemas.xmlsoap.org/soap/envelope/'>"
    +"<soap:Body >"
      +"  <LoginByTicket  xmlns='http://tempuri.org/'>"
        +"    <wsPwd>?</wsPwd>"
          +"  <wsUser>?</wsUser>"
        +"</LoginByTicket>"
    +"</soap:Body>"
    +"<soap:Header/>"
+"</soap:Envelope>";
		System.out.println(soapxml);
		LoginByTicketBody tt = new LoginByTicketBody();
		  Document document = DocumentHelper.parseText(soapxml);
		  Element root = document.getRootElement();
		 Element bodyNode= root.element("Body");
		 bodyNode.addAttribute(new QName("type", tt.getInstanceNameSpace()), tt.getBodyType());
		 System.out.println(document.asXML());
		Envelope envlop = JaxbUtils.fromXml(document.asXML(), Envelope.class);
		LoginByTicketBody tbody = (LoginByTicketBody)envlop.getBody();
		System.out.println(tbody.getLoginByTicket().getWsPwd());
	}
}
