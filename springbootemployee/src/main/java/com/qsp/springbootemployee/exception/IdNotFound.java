package com.qsp.springbootemployee.exception;

public class IdNotFound extends RuntimeException
{
	String message;
	
	@Override
	public String getMessage() {
		return message;
	}

	public IdNotFound(String message) 
	{
		
		this.message = message;
	}
	
}
