package com.list.MusicDirectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.configuration.AWSConfiguration;
import com.httpConnector.HTTPConnectorService;
import com.newregistration.RegisterMusicDirectorConnector;
import com.newregistration.RegisterMusicDirectorURLService;

@SpringBootApplication
public class MusicDirectorsApplication {

	@Value("${music.core.url}") String coreURL;
	
	public static void main(String[] args) {
		
		SpringApplication.run(MusicDirectorsApplication.class, args);
	}
	
	@Bean
	public AWSCredentialsProvider awsCredentials() {
		return new AWSConfiguration().awsCredentials();	
	}
	
	@Bean
	public RegisterMusicDirectorConnector connector() {
		return new RegisterMusicDirectorConnector();
	}
	
	@Bean
	public RegisterMusicDirectorURLService urlService() {
		return new RegisterMusicDirectorURLService(coreURL);
	}
	
	@Bean
	public HTTPConnectorService httpconnectService() {
		return new HTTPConnectorService();
	}
	
	
	@Bean(name="myRestTemplate")
	public RestOperations myRestTemplate() {
		final RestTemplate restTemplate=new RestTemplate();
		restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
		final DefaultUriBuilderFactory uriBuilderFactory=new DefaultUriBuilderFactory();
		uriBuilderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);
		restTemplate.setUriTemplateHandler(uriBuilderFactory);
		return restTemplate;
	}
	
}
