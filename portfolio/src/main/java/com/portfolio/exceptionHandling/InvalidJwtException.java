package com.portfolio.exceptionHandling;

import javax.naming.AuthenticationException;

public class InvalidJwtException extends AuthenticationException{

	
	public InvalidJwtException(String message) {
		super(message);
	}
}
