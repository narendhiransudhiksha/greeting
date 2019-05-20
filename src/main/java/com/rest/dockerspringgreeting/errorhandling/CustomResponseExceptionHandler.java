package com.rest.dockerspringgreeting.errorhandling;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
 *  Exception Handler for Custom Message.
 * 
 */
@ControllerAdvice
public class CustomResponseExceptionHandler{
	
	Logger logger = LoggerFactory.getLogger(CustomResponseExceptionHandler.class);

	@ExceptionHandler(IllegalArgumentException.class)
	public void handleBadRequests(HttpServletResponse response) throws IOException {
	    response.sendError(HttpStatus.NOT_FOUND.value(), "Path is not yet implemented.");
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public void handleConstraintViolation(HttpServletResponse response,ConstraintViolationException exception) throws IOException {		
		logger.error("ContraintViolation",exception);
		response.sendError(HttpStatus.BAD_REQUEST.value(),exception.getLocalizedMessage());
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class )
	public void handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException exception, HttpServletResponse response) throws IOException {	    
		logger.error("MethodArgumentTypeMismatch",exception);
		response.sendError(HttpStatus.BAD_REQUEST.value(),exception.getLocalizedMessage());
	}
	
}
