package com.project1.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionhandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<String> NotFoundException(NotFoundException ex){
		String msg=ex.exceptionMsg;
		return new ResponseEntity<String>(msg,HttpStatus.NOT_FOUND);
	}
}
