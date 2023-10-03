package com.qsp.springbootemployee.exception;

public class PhoneNotPresent extends RuntimeException
{
	String message;
	
	@Override
	public String getMessage() 
	{
		return message;
	}

	public PhoneNotPresent(String message) {
		super();
		this.message = message;
	}
	
}
