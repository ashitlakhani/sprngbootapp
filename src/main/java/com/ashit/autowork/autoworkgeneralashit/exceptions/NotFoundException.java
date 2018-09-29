package com.ashit.autowork.autoworkgeneralashit.exceptions;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5325169035704438366L;

	private NotFoundErrorDetails details;

	public NotFoundException(NotFoundErrorDetails details) {
		super();
		this.details = details;

	}

	public NotFoundException() {
		super();
	}

	public NotFoundErrorDetails getDetails() {
		return details;
	}

	public void setDetails(NotFoundErrorDetails details) {
		this.details = details;
	}


}
