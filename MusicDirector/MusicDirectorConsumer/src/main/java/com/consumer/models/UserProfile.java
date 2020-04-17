package com.consumer.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@DynamoDBTable(tableName = "UserProfile")
public class UserProfile {
	
	@DynamoDBHashKey
	int userID;
	@DynamoDBAttribute(attributeName = "Name")
	String Name;
	@DynamoDBAttribute
	char Email;
	@DynamoDBAttribute
	int Age;
	@DynamoDBAttribute
	String Address;

	public UserProfile() {}
}
