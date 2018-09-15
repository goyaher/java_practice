package com.springhibernateexample.vo.common;

public class ResponseVO 
{
	private int success;
	private String message; //message is populated only for failure (if success = 0);
	
	public ResponseVO(int success, String message)
	{
		this.success = success;
		this.message = message;
	}
	
	public ResponseVO(int success)
	{
		this.success = success;
	}
	
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
