package com.portfolio.exceptionHandling;


import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.portfolio.dto.StandardResponse;
import com.portfolio.dto.ValidationErrorResponse;
import com.portfolio.dto.Violation;
import com.portfolio.utils.ResponseMessages;

import jakarta.validation.ConstraintViolation;

import org.springframework.security.authentication.BadCredentialsException;


@ControllerAdvice

public class GlobalExceptionHandler {

	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<StandardResponse>handleRunTimeExecption(Exception ex) {
		System.out.println(ex);
		
		StandardResponse<Integer> response = new StandardResponse<Integer>(ex.getMessage(),ResponseMessages.SUCCESS_MESSAGE);
		
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	@ExceptionHandler(value = InvalidJwtException.class)
	public ResponseEntity<StandardResponse> handleJwtErrors(InvalidJwtException ex)
	{
		StandardResponse<Integer> response = new StandardResponse<Integer>(ex.getMessage(),ResponseMessages.FORBIDDEN);
		return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
		
	}
	
	@ExceptionHandler(value = BadCredentialsException.class)
	public ResponseEntity<StandardResponse> handleBadCredentialsException(BadCredentialsException ex)
	{
		StandardResponse<Integer> response = new StandardResponse<Integer>(ex.getMessage(),ResponseMessages.UNAUTHORIZED_CODE);
		return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
		
	}
	
	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<StandardResponse> handleNotFoundException(Exception ex)
	{
		StandardResponse<Integer> response = new StandardResponse<Integer>(ex.getMessage(),ResponseMessages.NOT_FOUND_CODE);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(value = IntegrityViolationException.class)
	public ResponseEntity<StandardResponse> handleNotFoundException(org.hibernate.exception.ConstraintViolationException ex)
	{
		StandardResponse<Integer> response = new StandardResponse<Integer>(ex.getMessage(),ResponseMessages.CONFLICT_STATUS_CODE);
		return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		
	}
	
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	  public ResponseEntity<StandardResponse> onConstraintValidationException(
	      ConstraintViolationException e) {
	    ValidationErrorResponse error = new ValidationErrorResponse();
	    for (ConstraintViolation violation : e.getConstraintViolations()) {
	      error.getViolations().add(
	        new Violation(violation.getPropertyPath().toString(), violation.getMessage()));
	    }
	    StandardResponse<ValidationErrorResponse> response = new StandardResponse<ValidationErrorResponse>(error,ResponseMessages.BAD_REQUEST_MESSAGE, ResponseMessages.BAD_REQUEST);
	   return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	  }
	

	
	  @ExceptionHandler(value = MethodArgumentNotValidException.class)
	  public ResponseEntity<StandardResponse>  onMethodArgumentNotValidException(
	      MethodArgumentNotValidException e) {
	    ValidationErrorResponse error = new ValidationErrorResponse();
	    for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
	      error.getViolations().add(
	        new Violation(fieldError.getField(), fieldError.getDefaultMessage()));
	    }
	    StandardResponse<ValidationErrorResponse> response = new StandardResponse<ValidationErrorResponse>(error,ResponseMessages.BAD_REQUEST_MESSAGE, ResponseMessages.BAD_REQUEST);
	    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	  }
	
	
}
