package rate.musicdirector.operations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestOperations;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import rate.musicdirector.model.MusicDirector;
import rate.musicdirector.model.MusicDirectorDetails;
import rate.musicdirector.model.RatingDetails;
import rate.musicdirector.model.UserProfile;

@Repository
public class MusicDirectorServicesRepository {
	
	@Autowired
	RestOperations restTemplate;
	
	@Autowired
	MusicDirectorURLServices urlService;
	
	@Autowired
	DynamoDBMapper mapper;
	
	@Autowired
	MusicDirectorMapperServices objectMapper;
	
	public void rateMusicDirectorAndSaveRatedUser(final RatingDetails ratingDetails, MusicDirector musicDirector) {
		
		final double userRating=ratingDetails.getRating();
		final UserProfile ratedBy=ratingDetails.getUserProfile();
		Map<String,Double> Ratings=musicDirector.getRatings();
		if(Ratings==null)
			Ratings=new HashMap<String,Double>();
		Ratings.put(String.valueOf(ratedBy.getUserID()), userRating);
		musicDirector.setRatings(Ratings);
		mapper.save(musicDirector);
		saveDetailsOfUser(ratedBy);
		
	}

	private void saveDetailsOfUser(final UserProfile ratedBy) {
		mapper.save(ratedBy);
	}

	public MusicDirector getMusicDirectorById(int musicDirectorID) {
		
		return restTemplate.getForObject(urlService.getFinalUrl()+musicDirectorID, MusicDirector.class);
	
	}
	
	public double getAvgRating(int musicDirectorID) {
		
		Map<String,Double> ratings = getRatings(musicDirectorID);
		double avgRating = ratings.entrySet().stream().map(e->e.getValue()).collect(Collectors.averagingDouble(r->r));
		return avgRating;
		
	}

	public boolean isUserAlreadyRatedMusicDirector(final int musicDirectorID, final int userID) {
		
		Map<String,Double> ratings = getRatings(musicDirectorID);
		boolean isUserAlreadyRated = ratings.entrySet().stream().map(rating->Integer.valueOf(rating.getKey())).anyMatch(user->user==userID);
		return isUserAlreadyRated;
		
	}

	private Map<String, Double> getRatings(int musicDirectorID) {
		
		return getMusicDirectorById(musicDirectorID).getRatings();
	}
	
	public int getRatingsCount(int musicDirectorID) {
		
		return getMusicDirectorById(musicDirectorID).getRatings().size();
		
	}

	public List<MusicDirectorDetails> getLeaderBoard() {
		
		List<MusicDirector> musicDirectors = getAllMusicDirectors();
		List<MusicDirectorDetails> sortedMusicDirectors = getMusicDirectorsWithRating(musicDirectors);
		return sortedMusicDirectors;
		
	}
	
	private List<MusicDirectorDetails> getMusicDirectorsWithRating(List<MusicDirector> musicDirectors) {
		
		return musicDirectors.stream()
		.map(musicDirector->objectMapper.mapToMusicDirectorDetails(musicDirector))
		.sorted((details1,details2)->Double.compare(details2.getRating(),details1.getRating()))
		.collect(Collectors.toList());
		
	}

	private List<MusicDirector> getAllMusicDirectors(){
		
//		List<MusicDirector> musicDirectors = Arrays.asList(restTemplate.getForObject(urlService.getGetAllUrl(), MusicDirector[].class));
//		return musicDirectors;
		ResponseEntity<List<MusicDirector>> musicDirectors = restTemplate.exchange(urlService.getGetAllUrl(),HttpMethod.GET,null,new ParameterizedTypeReference<List<MusicDirector>>() {});
		return musicDirectors.getBody();
		
	}

}
