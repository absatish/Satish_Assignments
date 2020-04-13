package rate.musicdirector.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class AmazonDynamoDBConfiguration {

	@Bean
	public DynamoDBMapper dynamoDBMapper(AmazonDynamoDB dynamoDB) {
		return new DynamoDBMapper(dynamoDB);
	}
}
