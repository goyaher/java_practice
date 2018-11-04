package com.hgoyal.springbootexample.dto;

public class Greeting {
	
	private int id;
	private String message;
	
	public Greeting(int id, String msg)
	{
		this.id = id;
		this.message = msg;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
