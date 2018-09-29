package com.ashit.autowork.autoworkgeneralashit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TodoItem implements Serializable{


	private static final long serialVersionUID = 5260971379332106047L;
	
	@Id
	@GeneratedValue
	private int id;

	@Column(name="text")
	private String text;
	
	@Column(name="is_completed")
	private boolean isCompleted;
	
	@Column(name="created_at")
	private String createdAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public TodoItem(int id, String text, boolean isCompleted, String createdAt) {
		super();
		this.id = id;
		this.text = text;
		this.isCompleted = isCompleted;
		this.createdAt = createdAt;
	}

	public TodoItem() {
		super();
	}

	public TodoItem(String text, boolean isCompleted, String createdAt) {
		super();
		this.text = text;
		this.isCompleted = isCompleted;
		this.createdAt = createdAt;
	} 
	
	
	
}
