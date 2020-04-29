package rate.musicdirector.operations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rate.musicdirector.model.MusicDirector;
import rate.musicdirector.model.MusicDirectorDetails;
import rate.musicdirector.model.RatingDetails;

@RestController
@RequestMapping("/")
public class MusicDirectorServicesController {
	
	@Autowired
	MusicDirectorServicesRepository repository;
	
	@Autowired
	MusicDirectorValidationServices validator;
	
	@Autowired
	MusicDirectorMapperServices objectMapper;

	@GetMapping("/home")
	public String showHomePage() {
		return "Vote to your favorite Music Director. "
				+ "<br/><b>Note : </b><i><u>Make sure the correctness of Music Director's "
				+ "ID that you are voting to</u></i>";
	}
	
	@GetMapping("/details/{ID}")
	public MusicDirectorDetails getMusicDirectorProfileById(@PathVariable("ID") int musicDirectorID){
		MusicDirector musicDirector = getMusicDirectorById(musicDirectorID);
		MusicDirectorDetails musicDirectorDetails = objectMapper.mapToMusicDirectorDetails(musicDirector);
		return musicDirectorDetails;
	}
	
	public MusicDirector getMusicDirectorById(int musicDirectorID){
		return repository.getMusicDirectorById(musicDirectorID);
	}
	
	@PostMapping("/rate")
	public MusicDirector rateMusicDirectorAndSaveRatedUser(@RequestBody RatingDetails ratingDetails) throws Exception{
		validator.validateRatingDetails(ratingDetails);
		MusicDirector musicDirector = getMusicDirectorById(ratingDetails.getMusicDirectorID());
		repository.rateMusicDirectorAndSaveRatedUser(ratingDetails,musicDirector);
		return getMusicDirectorById(ratingDetails.getMusicDirectorID());
	}
	
	@GetMapping("/leaderboard")
	public List<MusicDirectorDetails> getLeaderBoard(){
		
		return repository.getLeaderBoard();
		
	}	

}
