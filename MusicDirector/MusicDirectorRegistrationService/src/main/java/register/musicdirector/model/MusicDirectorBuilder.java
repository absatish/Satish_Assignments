package register.musicdirector.model;

import java.util.Map;

public class MusicDirectorBuilder {
	
	int musicDirectorID;
	String musicDirectorName;
	int noOfAwards;
	int noOfMovies;
	int noOfSongs;
	Map<String, Double> ratings;
	
	public MusicDirectorBuilder() {
		
	}
	
	public MusicDirectorBuilder MusicDirectorID(final int musicDirectorID) {
		this.musicDirectorID = musicDirectorID;
		return this;
	}
	
	public MusicDirectorBuilder MusicDirectorName(final String musicDirectorName) {
		this.musicDirectorName = musicDirectorName;
		return this;
	}
	
	public MusicDirectorBuilder NoOfAwards(final int noOfAwards) {
		this.noOfAwards = noOfAwards;
		return this;
	}
	
	public MusicDirectorBuilder NoOfMovies(final int noOfMovies) {
		this.noOfMovies = noOfMovies;
		return this;
	}
	
	public MusicDirectorBuilder NoOfSongs(final int noOfSongs) {
		this.noOfSongs = noOfSongs;
		return this;
	}
	
	public MusicDirectorBuilder Ratings(final Map<String, Double> ratings) {
		this.ratings = ratings;
		return this;
	}
	
	public MusicDirector build() {
		MusicDirector musicDirector = new MusicDirector();
		musicDirector.setMusicDirectorID(musicDirectorID);
		musicDirector.setMusicDirectorName(musicDirectorName);
		musicDirector.setNoOfAwards(noOfAwards);
		musicDirector.setNoOfMovies(noOfMovies);
		musicDirector.setNoOfSongs(noOfSongs);
		musicDirector.setRatings(ratings);
		return musicDirector;
	}
	
}
