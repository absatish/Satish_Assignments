package com.configuration;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.togglz.core.user.FeatureUser;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;

public class DynamoDBConfiguration {	
	
	@Bean
	@Autowired
	public DynamoDBMapperConfig dynDBMapper(DynamoDBMapperConfig.TableNameResolver tableName) {
		
		DynamoDBMapperConfig.Builder builder=new DynamoDBMapperConfig.Builder();
		builder.setTableNameResolver(tableName);
		return builder.build();
	}
	
	
	
	
}
