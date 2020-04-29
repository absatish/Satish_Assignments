package register.musicdirector.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

import register.musicdirector.model.MusicDirector;

@Service
public class MusicDirectorServicesRepository {
	
	@Autowired
	DynamoDBMapper mapper;
	
	@Autowired
	MusicDirectorValidationServices validations;
	

	public boolean registerNewMusicDirector(MusicDirector musicDirector){
		boolean isMusicDirectorAlreadyRegistered = validations.validateMusicDirector(musicDirector);
		if(isMusicDirectorAlreadyRegistered)
			mapper.save(musicDirector);
		return isMusicDirectorAlreadyRegistered;
	}

	public MusicDirector getMusicDirectorById(int ID) {
		return mapper.scan(MusicDirector.class, new DynamoDBScanExpression()).stream().filter(md->md.getMusicDirectorID()==ID).findFirst().get();
	}

	public List<MusicDirector> getAllMusicDirectors() {
		
		return mapper.scan(MusicDirector.class, new DynamoDBScanExpression()).stream().collect(Collectors.toList());
		
	}

	public boolean updateMusicDirectorProfile(int musicDirectorID, int noOfMovies, int noOfAwards, int noOfSongs) {
		Map<String, Double> ratings = getMusicDirectorById(musicDirectorID).getRatings();
		String musicDirectorName = getMusicDirectorById(musicDirectorID).getMusicDirectorName();
		MusicDirector updatedMusicDirector = MusicDirector.builder().MusicDirectorID(musicDirectorID).MusicDirectorName(musicDirectorName).NoOfMovies(noOfMovies).NoOfSongs(noOfSongs).NoOfAwards(noOfAwards).Ratings(ratings).build();
		mapper.save(updatedMusicDirector);
		return true;
	}
}
