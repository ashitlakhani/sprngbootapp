package com.ashit.autowork.autoworkgeneralashit.exceptions;

import java.io.Serializable;

public class NotFoundExceptionResponse implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 6229445032244508224L;
	private NotFoundErrorDetails details;
	private String name;
	
	
	
	public NotFoundExceptionResponse(NotFoundErrorDetails details, String name) {
		super();
		this.details = details;
		this.name = name;
	}
	public NotFoundErrorDetails getDetails() {
		return details;
	}
	public void setDetails(NotFoundErrorDetails details) {
		this.details = details;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
