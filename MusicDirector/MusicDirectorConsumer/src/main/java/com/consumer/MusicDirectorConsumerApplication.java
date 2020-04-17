package com.consumer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.consumer.configuration.AWSConfiguration;

@SpringBootApplication
public class MusicDirectorConsumerApplication {


	public static void main(String[] args) {
		
		SpringApplication.run(MusicDirectorConsumerApplication.class, args);
	}
	
	@Bean
	public AWSCredentialsProvider getAwsCredentials() {
		return new AWSConfiguration().awsCredentials();	
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
