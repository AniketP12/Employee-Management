package com.qsp.springbootemployee.exception;

public class EmailNotPresent extends RuntimeException
{
	String message;
	
	@Override
	public String getMessage() 
	{
		return message;
	}

	public EmailNotPresent(String message) {
		super();
		this.message = message;
	}
	
}
