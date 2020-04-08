package com.model.common;

//import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Error {

	int code;
	String summary;
	String description;
	
	
}
