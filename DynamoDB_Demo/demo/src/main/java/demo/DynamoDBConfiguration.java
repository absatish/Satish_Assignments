package demo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamoDBConfiguration {

	static final String awsAccessKey="AKIAZUYAFECLRFV5IXPF";
	static final String awsSecretKey="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";
	static final String awsDynamoDBEndPoint="dynamodb.us-east-2.amazonaws.com";
	static final String awsRegion="us-east-2";
	
	@Bean
	public DynamoDBMapper mapper()
	{
		return new DynamoDBMapper(amazonDynamoDBConfig());
	}
	
	
	private AmazonDynamoDB amazonDynamoDBConfig() {
		return AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(awsDynamoDBEndPoint,awsRegion))
				.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey)))
				.build();
	}

	@Bean
	public AWSCredentials amazonCredentials() {
		return new BasicAWSCredentials(awsAccessKey,awsSecretKey);
	}
}
