package register.musicdirector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import register.musicdirector.configuration.AWSConfiguration;

@SpringBootApplication
public class RegisterMusicDirectorMicroServiceApplication {
   
	public static void main(String[] args) {
		SpringApplication.run(RegisterMusicDirectorMicroServiceApplication.class, args);
	}
	

	
	@Bean(name = "Credentails")
	public AWSCredentialsProvider Credentials() {
		return new AWSConfiguration().awsCredentials();
	}
	
	@Bean
	public AmazonDynamoDB getAmazonDynamoDB() {
		return new AWSConfiguration().getDynamoDBInstance(Credentials());
	}
	
	@Bean
	public DynamoDBMapper getMapper() {
		return new AWSConfiguration().mapper(getAmazonDynamoDB());
	}
}
