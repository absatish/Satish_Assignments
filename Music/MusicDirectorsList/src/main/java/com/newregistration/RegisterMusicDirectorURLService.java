package com.newregistration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Service
@Getter
public class RegisterMusicDirectorURLService {

	private String finalURL;
	private final String URLForRegistration="register";
	
	
	public RegisterMusicDirectorURLService(final String coreURL) {
		//System.out.println("rr"+coreURL);
		this.finalURL=coreURL+"/"+URLForRegistration;
	}
	
}
