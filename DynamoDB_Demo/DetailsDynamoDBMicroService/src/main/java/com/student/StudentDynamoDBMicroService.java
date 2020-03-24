package com.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentDynamoDBMicroService {

	public static void main(String[] args){
		SpringApplication.run(StudentDynamoDBMicroService.class,args);
	}
}
