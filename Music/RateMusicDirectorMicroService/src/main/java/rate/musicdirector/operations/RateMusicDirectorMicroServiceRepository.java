package rate.musicdirector.operations;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestOperations;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import rate.musicdirector.model.MusicDirector;
import rate.musicdirector.model.RatingDetails;
import rate.musicdirector.model.UserProfile;

@Repository
public class RateMusicDirectorMicroServiceRepository {
	
	@Autowired
	RestOperations restTemplate;
	
	@Autowired
	RateMusicDirectorMicroServiceURLServices urlService;
	
	@Autowired
	DynamoDBMapper mapper;
	
	public void rateMusicDirector(final RatingDetails ratingDetails, MusicDirector musicDirector) {
		
		final double userRating=ratingDetails.getRating();
		final UserProfile ratedBy=ratingDetails.getUserProfile();
		Map<String,Double> Ratings=musicDirector.getRatings();
		if(Ratings==null)
			Ratings=new HashMap<String,Double>();
		Ratings.put(String.valueOf(ratedBy.getUserID()), userRating);
		musicDirector.setRatings(Ratings);
		mapper.save(musicDirector);
		mapper.save(ratedBy);
		
	}

	public MusicDirector getMusicDirector(int musicDirectorID) {
		
		return restTemplate.getForObject(urlService.getFinalUrl()+musicDirectorID, MusicDirector.class);
	
	}
	
	public double getAvgRating(int musicDirectorID) {
		
		Map<String,Double> ratings = getRatings(musicDirectorID);
		double avgRating = ratings.entrySet().stream().map(e->e.getValue()).collect(Collectors.averagingDouble(r->r));
		return avgRating;
		//return 0;
		
	}

	public boolean checkIfUserAlreadyRatedToMusicDirector(int musicDirectorID, int userID) {
		
		Map<String,Double> ratings = getRatings(musicDirectorID);
		boolean isUserAlreadyRated = ratings.entrySet().stream().map(rating->Integer.valueOf(rating.getKey())).anyMatch(user->user==userID);
		return isUserAlreadyRated;
		
	}

	private Map<String, Double> getRatings(int musicDirectorID) {
		
		
		return getMusicDirector(musicDirectorID).getRatings();
	}

}
