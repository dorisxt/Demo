package com.doris.soap;

import javax.xml.bind.annotation.XmlElement;

public class ResultModeOfString {

	private boolean isSucceed;
	private int errCode;
	private String rtnMsg;
	private String data;

	public boolean isSucceed() {
		return isSucceed;
	}

	@XmlElement(name = "IsSucceed", namespace = Namespaces.TEM_URI)
	public void setSucceed(boolean isSucceed) {
		this.isSucceed = isSucceed;
	}

	public int getErrCode() {
		return errCode;
	}

	@XmlElement(name = "ErrCode", namespace = Namespaces.TEM_URI)
	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

	public String getRtnMsg() {
		return rtnMsg;
	}

	@XmlElement(name = "RtnMsg", namespace = Namespaces.TEM_URI)
	public void setRtnMsg(String rtnMsg) {
		this.rtnMsg = rtnMsg;
	}

	public String getData() {
		return data;
	}

	@XmlElement(name = "Data", namespace = Namespaces.TEM_URI)
	public void setData(String data) {
		this.data = data;
	}

}
