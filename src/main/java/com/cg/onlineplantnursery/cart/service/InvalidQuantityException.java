package com.cg.onlineplantnursery.cart.service;

public class InvalidQuantityException extends Exception {
	@Override
	public String getMessage() {
		
		return "Invalid quantity added";
	}

}
