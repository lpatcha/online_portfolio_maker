package com.portfolio.exceptionHandling;

import org.hibernate.exception.ConstraintViolationException;

public class IntegrityViolationException extends ConstraintViolationException{

	public IntegrityViolationException(String msg) {
		
		super(msg, null, null);
	}
	
}
