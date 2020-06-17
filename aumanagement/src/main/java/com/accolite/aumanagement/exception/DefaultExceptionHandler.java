package com.accolite.aumanagement.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(CustomException.class)
	public final ResponseEntity<ErrorMessage> handleNotFoundException(CustomException ex, WebRequest request) {
		 ErrorMessage response = new ErrorMessage(new Date(), ex.getMessage(),
				request.getDescription(false),HttpStatus.NOT_ACCEPTABLE.getReasonPhrase());
		return new ResponseEntity<ErrorMessage>(response,HttpStatus.NOT_ACCEPTABLE);
	}
}
