package com.consumer.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import com.consumer.httpConnector.HTTPConnectorService;
import com.consumer.models.MusicDirector;
import com.consumer.models.RatingDetails;

@Service
public class MusicDirectorConnector {
	
	@Autowired
	private RestOperations restOperations;
	@Autowired
	private MusicDirectorURLServices urlService;
	@Autowired
	private HTTPConnectorService httpService;
	
	public MusicDirectorConnector() {
		
	}
	public MusicDirectorConnector(final RestOperations restOperations,final MusicDirectorURLServices urlService) {
		this.restOperations=restOperations;
		this.urlService=urlService;
	}
	
	public boolean regMusicDirector(final MusicDirector musicDirector) {
		return restOperations.exchange(urlService.getRegistrationURL(), HttpMethod.POST,httpService.getHttpEntityJson(musicDirector),boolean.class).getBody();
	}
	
	public List<MusicDirector> getLeaderBoardByRating() {
		return restOperations.exchange(urlService.getLeaderBoardURL(), HttpMethod.GET, null, new ParameterizedTypeReference<List<MusicDirector>>() {}).getBody();
	}
	
	public MusicDirector getMusicDirectorByID(int musicDirectorID) {
		return restOperations.exchange(urlService.getURLForMusicDirectorProfile()+musicDirectorID, HttpMethod.GET, null, MusicDirector.class).getBody();
	}
	
	public boolean rateMusicDirector(RatingDetails ratingDetails) {
		MusicDirector musicDirector = restOperations.exchange(urlService.getURLForMusicDirectorRating(), HttpMethod.POST,httpService.getHttpEntityJson(ratingDetails),MusicDirector.class).getBody();
		if(musicDirector==null) {
			return false;
		}
		return true;
	}
	
	public boolean updateMusicDirector(int musicDirectorID, int noOfSongs, int noOfMovies, int noOfAwards) {
		//restOperations.exchange(urlService.getRegistrationURL(), HttpMethod.PUT,)
		return restOperations.exchange(urlService.getURLForMusicDirectorUpdation()+"/"+musicDirectorID+"?movies="+noOfMovies+"&songs="+noOfSongs+"&awards="+noOfAwards, HttpMethod.PUT, null, boolean.class).getBody();
		
	}
	
	public List<MusicDirector> getMusicDirectorsSortedBy(String sortBy) {
		
		if(sortBy.compareTo("id")==0)
			return getMusicDirectorsSortedByID();
		if(sortBy.compareTo("name")==0)
			return getMusicDirectorsSortedByName();
		if(sortBy.compareTo("songs")==0)
			return getMusicDirectorsSortedByNumberOfSongs();
		if(sortBy.compareTo("awards")==0)
			return getMusicDirectorsSortedByNumberOfAwards();
		if(sortBy.compareTo("movies")==0)
			return getMusicDirectorsSortedByNumberOfMovies();
		return null;
		
	}
	
	private List<MusicDirector> getMusicDirectorsSortedByID() {
		 
		List<MusicDirector> musicDirectors = getLeaderBoardByRating();
		return musicDirectors.stream().sorted((director1,director2)->Integer.compare(director1.getMusicDirectorID(), director2.getMusicDirectorID())).collect(Collectors.toList());
		
	}
	
	private List<MusicDirector> getMusicDirectorsSortedByName() {
		final List<MusicDirector> musicDirectors = getLeaderBoardByRating();
		return musicDirectors.stream().sorted((director1,director2)->director1.getMusicDirectorName().compareTo(director2.getMusicDirectorName())).collect(Collectors.toList());
	}
	
	private List<MusicDirector> getMusicDirectorsSortedByNumberOfSongs() {
		final List<MusicDirector> musicDirectors = getLeaderBoardByRating();
		return musicDirectors.stream().sorted((director1,director2)->Integer.compare(director1.getNoOfSongs(),director2.getNoOfSongs())).collect(Collectors.toList());
	}
	
	private List<MusicDirector> getMusicDirectorsSortedByNumberOfMovies() {
		final List<MusicDirector> musicDirectors = getLeaderBoardByRating();
		return musicDirectors.stream().sorted((director1,director2)->Integer.compare(director1.getNoOfMovies(),director2.getNoOfMovies())).collect(Collectors.toList());
	}
	
	private List<MusicDirector> getMusicDirectorsSortedByNumberOfAwards() {
		final List<MusicDirector> musicDirectors = getLeaderBoardByRating();
		return musicDirectors.stream().sorted((director1,director2)->Integer.compare(director1.getNoOfAwards(),director2.getNoOfAwards())).collect(Collectors.toList());
	}

}
