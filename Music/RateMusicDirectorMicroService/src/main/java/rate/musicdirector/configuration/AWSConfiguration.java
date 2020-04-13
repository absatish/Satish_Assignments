package rate.musicdirector.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.s3.model.Region;

@Configuration
public class AWSConfiguration {

	@Bean
	public AWSCredentialsProvider credentials() {
		return new DefaultAWSCredentialsProviderChain();
	}
	
	@Bean
	public AmazonDynamoDB getDynamoDBInstance(AWSCredentialsProvider credentails) {
		return AmazonDynamoDBClientBuilder
				.standard()
				.withCredentials(credentails)
				.withRegion(Region.US_East_2.name())
				.build();
	}
}
