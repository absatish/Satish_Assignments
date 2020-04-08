package com.newregistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import com.httpConnector.HTTPConnectorService;
import com.model.common.MusicDirector;

@Service
public class RegisterMusicDirectorConnector {
	
	private RestOperations restOperations;
	private RegisterMusicDirectorURLService urlService=new RegisterMusicDirectorURLService("");
	private HTTPConnectorService httpService;
	
	public RegisterMusicDirectorConnector() {
		
	}
	public RegisterMusicDirectorConnector(final RestOperations restOperations,final RegisterMusicDirectorURLService urlService) {
		this.restOperations=restOperations;
		this.urlService=urlService;
	}
	
	public boolean regMusicDirector(final MusicDirector musicDirector) {
		System.out.println(urlService.getFinalURL());
		restOperations.exchange(urlService.getFinalURL(), HttpMethod.POST,httpService.getHttpEntityJson(musicDirector),boolean.class);
		return false;
	}

}
