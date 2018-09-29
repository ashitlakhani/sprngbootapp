package com.ashit.autowork.autoworkgeneralashit.bean;

import java.io.Serializable;

public class ToDoItemUpdateRequest implements Serializable {

	private static final long serialVersionUID = -6801213095126891004L;
	
	private Boolean isCompleted;
	private String text;
	
	
	public Boolean getIsCompleted() {
		return isCompleted;
	}
	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
