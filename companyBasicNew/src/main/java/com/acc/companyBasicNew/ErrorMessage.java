package com.acc.companyBasicNew;


public class ErrorMessage {
	
	String message;
	String code;
	String description;

	public ErrorMessage() {
		
	}
	
	public ErrorMessage(String message, String code, String description) {
		super();
		this.message = message;
		this.code = code;
		this.description = description;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
