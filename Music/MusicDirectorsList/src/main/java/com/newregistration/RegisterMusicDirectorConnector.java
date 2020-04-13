package com.newregistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import com.httpConnector.HTTPConnectorService;
import com.model.common.MusicDirector;

@Service
public class RegisterMusicDirectorConnector {
	
	@Autowired
	private RestOperations restOperations;
	@Autowired
	private RegisterMusicDirectorURLService urlService;
	@Autowired
	private HTTPConnectorService httpService;
	
	public RegisterMusicDirectorConnector() {
		
	}
	public RegisterMusicDirectorConnector(final RestOperations restOperations,final RegisterMusicDirectorURLService urlService) {
		this.restOperations=restOperations;
		this.urlService=urlService;
	}
	
	public ResponseEntity<Boolean> regMusicDirector(final MusicDirector musicDirector) {
		return restOperations.exchange(urlService.getFinalURL(), HttpMethod.POST,httpService.getHttpEntityJson(musicDirector),boolean.class);
	}
	
	public boolean registration(MusicDirector musicDirector) {
		System.out.println(musicDirector.getMusicDirectorName());
		return true;
	}

}
