package rate.musicdirector.configuration;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import org.mockito.MockitoAnnotations;
import static org.assertj.core.api.Assertions.assertThat;


import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

public class AWSConfigurationTest {
	
	private AWSConfiguration awsConfig;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		awsConfig = new AWSConfiguration();
	}
	
	@Test
	public void AmazonDynamoDbTest() {
		AWSCredentialsProvider credentials = mock(AWSCredentialsProvider.class);
		assertThat(awsConfig.getDynamoDBInstance(credentials)).isExactlyInstanceOf(AmazonDynamoDBClient.class);
	}

}
