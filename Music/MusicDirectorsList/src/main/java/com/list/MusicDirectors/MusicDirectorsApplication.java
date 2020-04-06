package com.list.MusicDirectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.web.client.RestOperations;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.DefaultUriBuilderFactory;

@SpringBootApplication
public class MusicDirectorsApplication {
    
	public static void main(String[] args) {
		SpringApplication.run(MusicDirectorsApplication.class, args);
	}
	
//	@Bean(name="myRestTemplate")
//	public RestOperations myRestTemplate() {
//		final RestTemplate restTemplate=new RestTemplate();
//		restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
//		final DefaultUriBuilderFactory uriBuilderFactory=new DefaultUriBuilderFactory();
//		uriBuilderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);
//		restTemplate.setUriTemplateHandler(uriBuilderFactory);
//		return restTemplate;
//	}
	
	/*
	 * Spring boot @Primary Annotation
	 * Errorhandling Annotations
	 * Redis Template 
	 * Logger
	 */
}
