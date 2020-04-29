package register.musicdirector.model;

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
	@DynamoDBAttribute(attributeName = "noOfMovies")
	int noOfMovies;
	@DynamoDBAttribute(attributeName = "noOfAwards")
	int noOfAwards;
	@DynamoDBAttribute(attributeName = "noOfSongs")
	int noOfSongs;
	@DynamoDBAttribute(attributeName = "Ratings")
	Map<String,Double> ratings;
	
	public MusicDirector() {}
	
	public static MusicDirectorBuilder builder() {
		return new MusicDirectorBuilder();
	}
}
