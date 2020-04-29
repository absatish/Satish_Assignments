package com.consumer;

import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import com.amazonaws.auth.AWSCredentialsProvider;

@SpringBootTest
public class MusicDirectorConsumerApplicationTest {
	
	@InjectMocks
	private MusicDirectorConsumerApplication application;
	
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void awsCredentialsProvider() {
		final AWSCredentialsProvider credentials = application.getAwsCredentials();
		assertNotNull(credentials.getCredentials());
	}

}
