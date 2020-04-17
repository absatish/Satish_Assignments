package com.consumer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import com.consumer.httpConnector.HTTPConnectorService;
import com.consumer.models.MusicDirector;

@Service
public class MusicDirectorConnector {
	
	@Autowired
	private RestOperations restOperations;
	@Autowired
	private MusicDirectorURLServices urlService;
	@Autowired
	private HTTPConnectorService httpService;
	
	public MusicDirectorConnector() {
		
	}
	public MusicDirectorConnector(final RestOperations restOperations,final MusicDirectorURLServices urlService) {
		this.restOperations=restOperations;
		this.urlService=urlService;
	}
	
	public boolean regMusicDirector(final MusicDirector musicDirector) {
		return restOperations.exchange(urlService.getFinalURL(), HttpMethod.POST,httpService.getHttpEntityJson(musicDirector),boolean.class).getBody();
	}
	
	public boolean registration(MusicDirector musicDirector) {
		System.out.println(musicDirector.getMusicDirectorName());
		return true;
	}

}
