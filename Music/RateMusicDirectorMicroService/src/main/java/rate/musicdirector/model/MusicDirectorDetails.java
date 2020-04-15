package rate.musicdirector.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class MusicDirectorDetails {
	
	int musicDirectorID;

	String musicDirectorName;

	int noOfMovies;

	int noOfAwards;

	int noOfSongs;
	
	double rating;
	
	public MusicDirectorDetails() {}
}
