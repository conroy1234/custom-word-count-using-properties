package com.example.demo.model;

import java.util.Date;

public class Todo {

	private int id;
	private String description;
	private boolean isCompleted;
	private Date date;

	public Todo(int id, String description, boolean isCompleted, Date date) {
		super();
		this.id = id;
		this.description = description;
		this.isCompleted = isCompleted;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", description=" + description + ", isCompleted=" + isCompleted + ", date=" + date
				+ "]";
	}

}
