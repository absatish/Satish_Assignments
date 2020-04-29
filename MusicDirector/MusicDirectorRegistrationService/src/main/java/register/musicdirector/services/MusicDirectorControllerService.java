package register.musicdirector.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.auth.AWSCredentialsProvider;

import register.musicdirector.model.MusicDirector;

@RestController
@RequestMapping("/")
public class MusicDirectorControllerService{

	@Autowired
	MusicDirectorServicesRepository repository;
	
	@Autowired
	AWSCredentialsProvider credentialsProvider;
	
	
	@GetMapping("/home")
	public String getWelcomeMessage() {
		//return credentialsProvider.getCredentials().getAWSAccessKeyId();
		return "Welcome to Registration MicroService HomePage..!";
	}
	
	@PostMapping("/register")
	public boolean registerMusicDirector(@RequestBody MusicDirector musicDirector){
		
		musicDirector.setRatings(new HashMap<String,Double>());
		return repository.registerNewMusicDirector(musicDirector);
	}
	
	@PutMapping("/update/{musicDirectorID}")
	public boolean updateMusicDirectorProfile(final @PathVariable("musicDirectorID") int musicDirectorID, final @RequestParam("movies") int noOfMovies, final @RequestParam("awards") int noOfAwards, final @RequestParam("songs") int noOfSongs) {
		return repository.updateMusicDirectorProfile(musicDirectorID,noOfMovies,noOfAwards,noOfSongs);
	}
	
	@GetMapping("/getdetails")
	public MusicDirector getMusicDirectorProfile(@RequestParam("ID") int ID) {
		return repository.getMusicDirectorById(ID);
	}
	
	@GetMapping("/getAll")
	public List<MusicDirector> getAllMusicDirectors(){
		return repository.getAllMusicDirectors();
	}
	
}
