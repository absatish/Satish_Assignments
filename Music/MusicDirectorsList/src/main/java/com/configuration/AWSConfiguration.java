package com.configuration;

import org.springframework.cloud.aws.core.region.RegionProvider;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

public class AWSConfiguration {

	public AWSCredentialsProvider awsCredentialsProvider() {
		return new DefaultAWSCredentialsProviderChain();	
	}
	
	public AmazonDynamoDB amazonDynamoDB(AWSCredentialsProvider awsCredentialsProvider,RegionProvider awsRegionProvider) {
		return AmazonDynamoDBClientBuilder
				.standard()
				.withCredentials(awsCredentialsProvider)
				.withRegion(awsRegionProvider.getRegion().getName().toString())
				.build();
	}
}
