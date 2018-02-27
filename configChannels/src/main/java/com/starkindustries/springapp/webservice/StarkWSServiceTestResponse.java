package com.starkindustries.springapp.webservice;

import java.io.Serializable;

public class StarkWSServiceTestResponse  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	String errorCode;
	String errorMessage;
	
	public StarkWSServiceTestResponse(){};
	
	public StarkWSServiceTestResponse(String name, String errorCode,
			String errorMessage) {
		super();
		this.name = name;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
