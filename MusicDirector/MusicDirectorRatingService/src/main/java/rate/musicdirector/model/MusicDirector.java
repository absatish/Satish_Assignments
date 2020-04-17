package rate.musicdirector.model;

import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@DynamoDBTable(tableName = "musicdirectors")
public class MusicDirector {
	
	@DynamoDBHashKey(attributeName = "ID")
	int musicDirectorID;
	@DynamoDBAttribute(attributeName = "Name")
	String musicDirectorName;
	@DynamoDBAttribute
	int noOfMovies;
	@DynamoDBAttribute
	int noOfAwards;
	@DynamoDBAttribute
	int noOfSongs;
	@DynamoDBAttribute(attributeName = "Ratings")
	Map<String,Double> ratings;
	
	public MusicDirector() {}
}
