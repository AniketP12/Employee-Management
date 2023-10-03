package com.qsp.springbootemployee.exception;

public class NotInRange extends RuntimeException
{
	String message;
	@Override
	public String getMessage() {
		return message;
	}
	public NotInRange(String message) {
		super();
		this.message = message;
	}
	
}
