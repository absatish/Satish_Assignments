package microservice.configuration;

import org.springframework.context.annotation.Configuration;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.s3.model.Region;

@Configuration
public class AWSConfiguration {

	public AWSCredentialsProvider awsCredentials() {
		return new DefaultAWSCredentialsProviderChain();
	}

	public AmazonDynamoDB getDynamoDBInstance(AWSCredentialsProvider Credentails) {
		return AmazonDynamoDBClientBuilder
				.standard()
				.withCredentials(Credentails)
				.withRegion(Region.US_East_2.name().toString())
				.build();
	}
	
	public DynamoDBMapper mapper(AmazonDynamoDB amazonDynamoDB) {
		return new DynamoDBMapper(amazonDynamoDB);
	}
}
