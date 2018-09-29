package com.ashit.autowork.autoworkgeneralashit.bean;

import java.io.Serializable;

public class ToDoItemAddRequest implements Serializable {

	private static final long serialVersionUID = -6801213095126891004L;
	
	
	private String text;
	

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
