package rate.musicdirector.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import rate.musicdirector.model.MusicDirector;
import rate.musicdirector.model.RatingDetails;

@RestController
@RequestMapping("/")
public class RateMusicDirectorMicroServiceController {
	
	@Autowired
	RestOperations restTemplate;
	
	@Autowired
	RateMusicDirectorMicroServiceURLServices urlService;
	
	@Autowired
	RateMusicDirectorMicroServiceRepository repository;

	@GetMapping("/home")
	public String welcomeToHomePage() {
		return "Vote to your favorite Music Director. "
				+ "<br/><b>Note : </b><i><u>Make sure the correctness of Music Director's "
				+ "ID that you are voting to</u></i>";
	}
	
	@GetMapping("/know/{ID}")
	public ResponseEntity<MusicDirector> getMusicDirector(@PathVariable("ID") int musicDirectorID){
		return restTemplate.getForEntity(urlService.getFinalUrl()+musicDirectorID, MusicDirector.class);
	}
	
	@PatchMapping("/rate")
	public ResponseEntity<MusicDirector> rateMusicDirector(@RequestBody RatingDetails ratingDetails){
		repository.rateMusicDirector(ratingDetails);
		return getMusicDirector(ratingDetails.getID());
	}
}
