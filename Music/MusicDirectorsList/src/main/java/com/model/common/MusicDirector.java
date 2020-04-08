package com.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
//@AllArgsConstructor
//@Builder
public class MusicDirector {
	
	int musicDirectorID;
	String musicDirectorName;
	int noOfMovies;
	public int getMusicDirectorID() {
		return musicDirectorID;
	}
	public void setMusicDirectorID(int musicDirectorID) {
		this.musicDirectorID = musicDirectorID;
	}
	public String getMusicDirectorName() {
		return musicDirectorName;
	}
	public void setMusicDirectorName(String musicDirectorName) {
		this.musicDirectorName = musicDirectorName;
	}
	public int getNoOfMovies() {
		return noOfMovies;
	}
	public void setNoOfMovies(int noOfMovies) {
		this.noOfMovies = noOfMovies;
	}
	
	
}
