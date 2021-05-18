package com.cg.onlineplantnursery.exception;

public class PlantNotFoundException extends RuntimeException
{
	public PlantNotFoundException()
	{
		
	}
	
	public PlantNotFoundException(String msg)
	{
		super(msg);
		
	}
	
	public PlantNotFoundException(String msg,Throwable throwable)
	{
		super(msg,throwable);
		
	}
	

}
