package com.ashit.autowork.autoworkgeneralashit.exceptions;

import java.io.Serializable;

public class ValidationErrorDetails implements Serializable{

	
	private static final long serialVersionUID = 3784091500779233943L;
	private String location;
	private String param;
	private String msg;
	private String value;
	
	
	@SuppressWarnings("unused")
	private ValidationErrorDetails() {
		
	}
	
	public ValidationErrorDetails(String location, String param, String msg, String value) {
		super();
		this.location = location;
		this.param = param;
		this.msg = msg;
		this.value = value;
	}
	
	
	public ValidationErrorDetails(String msg) {
		super();
		this.msg = msg;
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
