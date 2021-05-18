package com.cg.onlineplantnursery.exception;

public class InvalidQuantityException extends Exception{

	@Override
	public String getMessage() {
		
		return "Invalid quantity added";
	}

	
	
}
