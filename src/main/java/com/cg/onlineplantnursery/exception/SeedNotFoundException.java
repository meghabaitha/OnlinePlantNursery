package com.cg.onlineplantnursery.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class SeedNotFoundException extends RuntimeException {
	
	public SeedNotFoundException()
	{
		
		
	}
	
	public SeedNotFoundException(String msg)
	{
		super(msg);
		
	}
	
	public SeedNotFoundException(String msg, Throwable throwable)
	{
		super(msg,throwable);
		
	}


}
