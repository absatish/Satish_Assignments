package rate.musicdirector.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

import rate.musicdirector.model.MusicDirector;
import rate.musicdirector.model.RatingDetails;
import rate.musicdirector.model.UserProfile;

@Repository
public class RateMusicDirectorMicroServiceRepository {
	
	@Autowired
	DynamoDBMapper mapper;
	
	public void rateMusicDirector(final RatingDetails ratingDetails) {
		
		final int MusicDirectorID=ratingDetails.getID();
		final double userRating=ratingDetails.getRating();
		final UserProfile ratedBy=ratingDetails.getUserProfile();
		final MusicDirector musicDirector=mapper.scan(MusicDirector.class, new DynamoDBScanExpression())
				.stream().filter(md->md.getMusicDirectorID()==MusicDirectorID).findFirst().get();
		musicDirector.setUserRating(userRating);
		mapper.save(musicDirector);
		mapper.save(ratedBy);
	}

}
