package student.marks;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class MarksDynamoDBConfiguration {
	
	static final String awsAccessKey="";
	static final String awsSecretKey="";
	static final String awsDynamoDBEndPoint="";
	static final String awsRegion="";
	
	@Bean
	public DynamoDBMapper dynamoDBMapper()
	{
		return new DynamoDBMapper(amazonDynamoDB());
	}

	public AmazonDynamoDB amazonDynamoDB()
	{
		EndpointConfiguration endpointconfig=new EndpointConfiguration(awsDynamoDBEndPoint, awsRegion);
		AWSCredentials credentials=new BasicAWSCredentials(awsAccessKey, awsSecretKey);
		AWSStaticCredentialsProvider credentialsProvider=new AWSStaticCredentialsProvider(credentials);
		return AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(endpointconfig)
				.withCredentials(credentialsProvider)
				.build();
	}
}
