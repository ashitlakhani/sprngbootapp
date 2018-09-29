package com.ashit.autowork.autoworkgeneralashit.bean;

import java.io.Serializable;

public class TodoItemResponse implements Serializable {

	private static final long serialVersionUID = -7948834847098528143L;
	private boolean isCompleted;
	private String text;
	private int id;
	private String createdAt;
	
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	
}
