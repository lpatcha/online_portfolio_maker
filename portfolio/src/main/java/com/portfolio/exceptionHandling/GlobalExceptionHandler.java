package com.portfolio.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.portfolio.dto.StandardResponse;
import com.portfolio.utils.ResponseMessages;

@ControllerAdvice
public class GlobalExceptionHandler {

//	@ExceptionHandler(value = Exception.class)
//	public ResponseEntity<StandardResponse>handleRunTimeExecption(Exception ex) {
//		
//		
//		StandardResponse<Integer> response = new StandardResponse<Integer>(ex.getMessage(),ResponseMessages.SUCCESS_MESSAGE);
//		
//		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//		
//	}
	
	
	@ExceptionHandler(value = InvalidJwtException.class)
	public ResponseEntity<StandardResponse> handleJwtErrors(InvalidJwtException ex)
	{
		StandardResponse<Integer> response = new StandardResponse<Integer>(ex.getMessage(),ResponseMessages.FORBIDDEN);
		return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
		
	}
	
	
}
