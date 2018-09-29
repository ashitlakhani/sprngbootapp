package com.ashit.autowork.autoworkgeneralashit.exceptions;

import java.io.Serializable;

public class ValidationExceptionResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 222447895357722301L;
	private ValidationErrorDetails details;
	private String name;
	
	
	
	public ValidationExceptionResponse(ValidationErrorDetails details, String name) {
		super();
		this.details = details;
		this.name = name;
	}
	public ValidationErrorDetails getDetails() {
		return details;
	}
	public void setDetails(ValidationErrorDetails details) {
		this.details = details;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
