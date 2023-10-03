package com.qsp.springbootemployee.exception;

public class NoDataAvailable extends RuntimeException
{
	String message;
	@Override
	public String getMessage() 
	{
		return message;
	}
	public NoDataAvailable(String message) {
		super();
		this.message = message;
	}
	
}
