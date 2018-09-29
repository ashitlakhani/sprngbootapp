package com.ashit.autowork.autoworkgeneralashit.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<ValidationExceptionResponse> handleValidationException(ValidationException vx, WebRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ValidationExceptionResponse resp = new ValidationExceptionResponse(vx.getDetails(), ValidationTypes.VALIDATIONERROR.name());		
		return new ResponseEntity<ValidationExceptionResponse>(resp, status);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<NotFoundExceptionResponse> handleNotFoundException(NotFoundException nfx, WebRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		NotFoundExceptionResponse resp = new NotFoundExceptionResponse(nfx.getDetails(), ValidationTypes.NOTFOUNDERROR.name());		
		return new ResponseEntity<NotFoundExceptionResponse>(resp, status);
	}
	
	
}
