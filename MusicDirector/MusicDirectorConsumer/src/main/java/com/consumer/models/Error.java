package com.consumer.models;

//import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Error {

	int refCode;
	String summary;
	String description;
	
	
}
