package rate.musicdirector.operations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rate.musicdirector.model.MusicDirector;
import rate.musicdirector.model.MusicDirectorDetails;
import rate.musicdirector.model.RatingDetails;

@RestController
@RequestMapping("/")
public class RateMusicDirectorMicroServiceController {
	
	@Autowired
	RateMusicDirectorMicroServiceRepository repository;
	
	@Autowired
	RateMusicDirectorMicroServiceValidations validator;

	@GetMapping("/home")
	public String welcomeToHomePage() {
		return "Vote to your favorite Music Director. "
				+ "<br/><b>Note : </b><i><u>Make sure the correctness of Music Director's "
				+ "ID that you are voting to</u></i>";
	}
	
	@GetMapping("/know/{ID}")
	public MusicDirectorDetails getMusicDirectorDetails(@PathVariable("ID") int musicDirectorID){
		MusicDirector musicDirector = getMusicDirector(musicDirectorID);
		System.out.println(musicDirector.getMusicDirectorID());
		double avgRating = repository.getAvgRating(musicDirectorID);
		MusicDirectorDetails musicDirectorDetails = new MusicDirectorDetails();
		musicDirectorDetails.setMusicDirectorID(musicDirectorID);
		musicDirectorDetails.setMusicDirectorName(musicDirector.getMusicDirectorName());
		musicDirectorDetails.setNoOfAwards(musicDirector.getNoOfAwards());
		musicDirectorDetails.setNoOfMovies(musicDirector.getNoOfMovies());
		musicDirectorDetails.setNoOfSongs(musicDirector.getNoOfSongs());
		musicDirectorDetails.setRating(avgRating);
		return musicDirectorDetails;
	}
	
	public MusicDirector getMusicDirector(int musicDirectorID){
		return repository.getMusicDirector(musicDirectorID);
		//restTemplate.getForEntity(urlService.getFinalUrl()+
		//musicDirectorID, MusicDirector.class);
	}
	
	@PatchMapping("/rate")
	public MusicDirector rateMusicDirector(@RequestBody RatingDetails ratingDetails) throws Exception{
		validator.validateRatingDetails(ratingDetails);
		MusicDirector musicDirector = getMusicDirector(ratingDetails.getMusicDirectorID());
		repository.rateMusicDirector(ratingDetails,musicDirector);
		return getMusicDirector(ratingDetails.getMusicDirectorID());
	}

}
