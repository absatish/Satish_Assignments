package com.list.MusicDirectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import com.model.common.Error;

@ControllerAdvice
public class MusicDirectorExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<Object> simleException(final Exception e,final WebRequest wr){
		HttpStatus status=HttpStatus.NOT_FOUND;
		//return ResponseEntity.status(status).body(e.getMessage()+","+e.getClass());
		return ResponseEntity.status(status).body(new Error(404,e.getLocalizedMessage(),e.getMessage()));
	}
	
	@ExceptionHandler(value= {HttpClientErrorException.class})
	public ResponseEntity<Object> clientErrorException(final HttpClientErrorException hce,final WebRequest wr){
		HttpStatus status=HttpStatus.NOT_FOUND;
		return ResponseEntity.status(status).body(hce);
	}

}
