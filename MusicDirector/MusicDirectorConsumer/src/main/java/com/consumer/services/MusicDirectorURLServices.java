package com.consumer.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Service
@Getter
public class MusicDirectorURLServices {

	private String finalURL;
	private final String URLForRegistration="register";
	
	
	public MusicDirectorURLServices(final @Value("${music.core.url}") String coreURL) {
		
		this.finalURL=coreURL+"/"+URLForRegistration;
	}
	
}
