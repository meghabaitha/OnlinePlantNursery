package com.cg.onlineplantnursery.planter.exception;

public class PlanterNotFoundException extends RuntimeException{

	public PlanterNotFoundException()
	{
		super();
	}
	public PlanterNotFoundException(String msg)
	{
		super(msg);
	}
	
	public PlanterNotFoundException(String msg, Throwable throwable)
	{
		super(msg,throwable);
		
	}
}
