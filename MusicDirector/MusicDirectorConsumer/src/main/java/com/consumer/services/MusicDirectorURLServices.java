package com.consumer.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Service
@Getter
public class MusicDirectorURLServices {

	private String RegistrationURL;
	private String LeaderBoardURL;
	private String URLForMusicDirectorProfile;
	private String URLForMusicDirectorRating;
	private String URLForMusicDirectorUpdation;
	private static final String URLPhraseForUpdation = "update";
	private static final String URLPhraseForRating = "rate";
	private static final String URLPhraseForRegistration = "register";
	private static final String URLPhraseForLeaderBoard = "leaderboard";
	
	
	public MusicDirectorURLServices(final @Value("${music.registration.url}") String registrationURL, final @Value("${music.rating.url}") String ratingURL ) {
		
		this.RegistrationURL=registrationURL+"/"+URLPhraseForRegistration;
		this.LeaderBoardURL = ratingURL+"/"+URLPhraseForLeaderBoard;
		this.URLForMusicDirectorProfile = ratingURL+"/"+"details/";
		this.URLForMusicDirectorRating = ratingURL+"/"+URLPhraseForRating;
		this.URLForMusicDirectorUpdation = registrationURL+"/"+URLPhraseForUpdation;
	}
	
	
	
}
