package com.newregistration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Getter
@Service
public class RegisterMusicDirectorURLService {

	private String finalURL;
	private static @Value("${musicDirector.Post.Register.url}") String URLForRegistration;
	
	public RegisterMusicDirectorURLService(final @Value("${musicDirector.Post.Core.url}") String coreURL) {
		System.out.println(URLForRegistration);
		this.finalURL=coreURL+"/"+URLForRegistration;
	}
	
}
