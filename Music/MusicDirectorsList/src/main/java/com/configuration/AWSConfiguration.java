package com.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.s3.model.Region;

@Configuration
public class AWSConfiguration {

	@Bean
	@Primary
	public AWSCredentialsProvider awsCredentials() {
		return new DefaultAWSCredentialsProviderChain();	
	}
	@Bean
	public AmazonDynamoDB awsDynamoDB(AWSCredentialsProvider credentials) {
		return AmazonDynamoDBClientBuilder
				.standard()
				.withCredentials(credentials)
				.withRegion(Region.US_East_2.name())
				.build();
	}
}
