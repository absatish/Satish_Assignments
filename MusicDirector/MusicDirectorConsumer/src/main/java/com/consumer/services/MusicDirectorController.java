package com.consumer.services;

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
import com.consumer.models.MusicDirector;
import com.consumer.models.RatingDetails;

@RestController
@RequestMapping("/")
public class MusicDirectorController {
	
	@Autowired
	MusicDirectorValidator validator;
	
	@Autowired
	AWSCredentialsProvider credentails;

	@Autowired
	MusicDirectorConnector connector;
	/*
	 * just for understanding purpose
	 * to check whether Environment variables are accessible
	 */
	@RequestMapping("/home")
	public String home(){
		return credentails.getCredentials().getAWSAccessKeyId(); 
	}
	
	@PostMapping("/register")
	public String registerNewMusicDirector(@RequestBody MusicDirector musicDirector) throws Exception{
		if(validator.validateMusicDirector(musicDirector))
		{
			if(connector.regMusicDirector(musicDirector))
				return "Registered Successfully..!";
			else
				throw new Exception("Music Director "+musicDirector.getMusicDirectorName()+"("+musicDirector.getMusicDirectorID()+") already registered..!");
		}
		throw new Exception("Invalid Data..!");
	}
	
	@PostMapping("/rate")
	public String rateMusicDirector(@RequestBody RatingDetails ratingDetails) {
		if(connector.rateMusicDirector(ratingDetails)) {
			return "Rating has been submitted successfully..!";
		}
		return "Something went wrong..!";
	}
	
	@PutMapping("/update/{musicDirectorID}")
	public String updateMusicDirector(final @PathVariable("musicDirectorID") int musicDirectorID, final @RequestParam("songs") int noOfSongs, final @RequestParam("movies") int noOfMovies, final @RequestParam("awards") int noOfAwards) {
		if(connector.updateMusicDirector(musicDirectorID, noOfSongs, noOfMovies, noOfAwards)) {
			return "Music Director Details Updated Successfully..!";
		}
		return "Something went wrong..! Failed to update the details..!";
	}
	
	@GetMapping("/sort/{sortBy}")
	public List<MusicDirector> getMusicDirectorsSortedBy(@PathVariable("sortBy") String sortBy){
		return connector.getMusicDirectorsSortedBy(sortBy);
	}
	
	@GetMapping("/leaderboard")
	public List<MusicDirector> getLeaderBoardByRating() {
		return connector.getLeaderBoardByRating();
	}
	
	@GetMapping("/details/musicdirector/{musicDirectorID}")
	public MusicDirector getMusicDirectorByID(@PathVariable("musicDirectorID") int musicDirectorID) {
		return connector.getMusicDirectorByID(musicDirectorID);
	}
	
}
