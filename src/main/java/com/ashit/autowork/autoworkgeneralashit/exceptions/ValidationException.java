package com.ashit.autowork.autoworkgeneralashit.exceptions;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 5325169035704438366L;

	private ValidationErrorDetails details;
	

	public ValidationException(ValidationErrorDetails details) {
		super();
		this.details = details;
		
	}

	public ValidationException() {
		super();
	}

	public ValidationErrorDetails getDetails() {
		return details;
	}

	public void setDetails(ValidationErrorDetails details) {
		this.details = details;
	}

}
