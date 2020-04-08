package com.list.MusicDirectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
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

	@Bean
	@Primary
	public AWSCredentialsProvider awsCredentials() {
		return new DefaultAWSCredentialsProviderChain();	
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
