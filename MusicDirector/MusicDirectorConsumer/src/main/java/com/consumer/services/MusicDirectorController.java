package com.consumer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.consumer.models.MusicDirector;

@RestController
@RequestMapping("/")
public class MusicDirectorController {
	
	@Autowired
	MusicDirectorValidator validator;
	
	@Autowired
	AWSCredentialsProvider credentails;

	@Autowired
	MusicDirectorConnector connector;
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
		if(validator.validateMusicDirector(musicDirector))
		{
			if(connector.regMusicDirector(musicDirector))
				return "Registered Successfully..!";
			else
				throw new Exception("Music Director "+musicDirector.getMusicDirectorName()+"("+musicDirector.getMusicDirectorID()+") already registered..!");
		}
		throw new Exception("Invalid Data..!");
	}
	
	@PostMapping("/newregistration")
	public void newRegistration(@RequestBody MusicDirector musicDirector) {
		if(connector.registration(musicDirector)) {
			System.out.println(true);
		}
	}
}
