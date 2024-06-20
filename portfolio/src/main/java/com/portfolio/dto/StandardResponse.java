package com.portfolio.dto;

public class StandardResponse <T>{
	public String message;
	public T result;
	public String statusCode;
	
	public StandardResponse(T body, String message, String statusCode) {
		this.message = message;
		this.result = body;
		this.statusCode = statusCode;
	}
	
	public StandardResponse(String message, String statusCode) {
		this.message = message;
		this.statusCode = statusCode;
		this.result = null;
		
	}
	
	
}
