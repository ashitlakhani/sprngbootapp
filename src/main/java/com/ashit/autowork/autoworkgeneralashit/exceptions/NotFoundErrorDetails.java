package com.ashit.autowork.autoworkgeneralashit.exceptions;

import java.io.Serializable;

public class NotFoundErrorDetails implements Serializable {

	
	private static final long serialVersionUID = -6900101493892524936L;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public NotFoundErrorDetails(String message) {
		super();
		this.message = message;
	}

	public NotFoundErrorDetails() {
		super();
		
	}
	
	
	
}
