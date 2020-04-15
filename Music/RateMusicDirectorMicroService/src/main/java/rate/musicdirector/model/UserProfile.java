package rate.musicdirector.model;

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
	
	@DynamoDBHashKey(attributeName = "userID")
	int userID;
	@DynamoDBAttribute(attributeName = "userName")
	String userName;
	@DynamoDBAttribute(attributeName = "emailID")
	String emailID;
	@DynamoDBAttribute(attributeName = "userAge")
	int userAge;
	@DynamoDBAttribute(attributeName = "userAddress")
	String userAddress;

	public UserProfile() {}
}
