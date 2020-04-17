package com.consumer.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MusicDirector {
	
	int musicDirectorID;
	String musicDirectorName;
	int noOfMovies;
	int noOfAwards;
	int noOfSongs;
	double userRating;
	
	public MusicDirector() {}
}
