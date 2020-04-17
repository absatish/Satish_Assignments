package rate.musicdirector.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rate.musicdirector.model.MusicDirector;
import rate.musicdirector.model.MusicDirectorDetails;

@Service
public class MusicDirectorMapperServices {
	
	@Autowired
	MusicDirectorServicesRepository repository;

	public MusicDirectorDetails mapToMusicDirectorDetails(final MusicDirector musicDirector) {
		
		double rating = repository.getAvgRating(musicDirector.getMusicDirectorID());
		int noOfRatings = repository.getRatingsCount(musicDirector.getMusicDirectorID());
		return new MusicDirectorDetails(musicDirector.getMusicDirectorID(),musicDirector.getMusicDirectorName(),musicDirector.getNoOfMovies(),musicDirector.getNoOfAwards(),musicDirector.getNoOfSongs(), rating, noOfRatings);
		
	}
}
