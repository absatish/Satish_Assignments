package rate.musicdirector.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rate.musicdirector.model.MusicDirector;
import rate.musicdirector.model.RatingDetails;
import rate.musicdirector.model.UserProfile;

@Service
public class MusicDirectorValidationServices {

	@Autowired
	MusicDirectorServicesRepository repository;
	
	public void validateRatingDetails(RatingDetails ratingDetails) throws Exception{
		
		int musicDirectorID = ratingDetails.getMusicDirectorID();
		double rating = ratingDetails.getRating();
		UserProfile userProfile = ratingDetails.getUserProfile();
		MusicDirector musicDirector=repository.getMusicDirectorById(musicDirectorID);
		if(musicDirector==null)
			throw new Exception("No Music Director found with ID : "+musicDirectorID);
		if(rating<0.0 || rating>5.0)
			throw new Exception("Invalid Rating : "+rating);
		if(repository.isUserAlreadyRatedMusicDirector(musicDirectorID,userProfile.getUserID()))
			throw new Exception("User ("+userProfile.getUserName()+") has already given the rating for Music Director "+musicDirector.getMusicDirectorName()+" ("+ musicDirectorID+")");
		
	}
	
}
