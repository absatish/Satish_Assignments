package rate.musicdirector.operations;

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
	public MusicDirectorDetails getMusicDirectorDetails(@PathVariable("ID") int musicDirectorID){
		MusicDirector musicDirector = getMusicDirector(musicDirectorID);
		MusicDirectorDetails musicDirectorDetails = objectMapper.mapToMusicDirectorDetails(musicDirector);
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
	
	@GetMapping("/leaderboard")
	public List<MusicDirectorDetails> getLeaderBoard(){
		
		return repository.getLeaderBoard();
		
	}	

}
