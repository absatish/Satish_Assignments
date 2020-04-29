package com.consumer.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import com.consumer.models.Error;

@ControllerAdvice
public class MusicDirectorExceptionHandler {
	

	@ExceptionHandler
	public ResponseEntity<Object> simpleException(final Exception e,final WebRequest wr){
		HttpStatus status=HttpStatus.NOT_FOUND;
		//return ResponseEntity.status(status).body(e.getMessage()+","+e.getClass());
		return ResponseEntity.status(status).body(new Error(e.hashCode(),e.getLocalizedMessage(),e.getMessage()));
	}
	
	@ExceptionHandler(value= {HttpClientErrorException.class})
	public ResponseEntity<Object> clientErrorException(final HttpClientErrorException hce,final WebRequest wr){
		HttpStatus status=HttpStatus.NOT_FOUND;
		return ResponseEntity.status(status).body(new Error(hce.getRawStatusCode(),hce.getLocalizedMessage(),hce.getMessage()));
	}

}
