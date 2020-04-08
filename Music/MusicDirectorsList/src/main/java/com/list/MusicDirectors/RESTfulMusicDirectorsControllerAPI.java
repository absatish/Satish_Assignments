package com.list.MusicDirectors;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;

import com.configuration.AWSConfiguration;
import com.model.common.MusicDirector;
import com.newregistration.RegisterMusicDirectorConnector;

@RestController
@RequestMapping("/")
public class RESTfulMusicDirectorsControllerAPI {
	
	@Autowired
	AWSCredentialsProvider credentails;

	//@Autowired
	RegisterMusicDirectorConnector connector=new RegisterMusicDirectorConnector();
	/*
	 * just for understanding purpose
	 * to check whether Environment variables are accessible
	 */
	@RequestMapping("/home")
	public String home(){
		return credentails.getCredentials().getAWSAccessKeyId(); 
	}
	
	@PostMapping("/register")
	public String registerNewMusicDirector(@RequestBody MusicDirector musicDirector) throws Exception{
		if(connector.regMusicDirector(musicDirector))
			return "Registered Successfully..!";
		throw new Exception("Something went wrong...Error while Registration..!");
	}
}
