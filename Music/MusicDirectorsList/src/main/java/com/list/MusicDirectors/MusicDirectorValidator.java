package com.list.MusicDirectors;

import org.springframework.stereotype.Service;

import com.model.common.MusicDirector;

@Service
public class MusicDirectorValidator {
	
	public boolean validateMusicDirector(MusicDirector musicDirector) throws Exception {
		if(validateName(musicDirector.getMusicDirectorName())
				&& validateID(musicDirector.getMusicDirectorID())
				&& validateNoOfMovies(musicDirector.getNoOfMovies())
				&& validateNoOfAwards(musicDirector.getNoOfAwards())
				&& validateNoOfSongs(musicDirector.getNoOfSongs())
				)
			return true;
		return false;
	}

	private boolean validateNoOfSongs(int noOfSongs) {
		if(noOfSongs<0)
			return false;
		return true;
	}

	private boolean validateNoOfAwards(int noOfAwards) {
		if(noOfAwards<0)
			return false;
		return true;
	}

	private boolean validateNoOfMovies(int noOfMovies) {
		if(noOfMovies<0)
			return false;
		return true;
	}

	private boolean validateID(int musicDirectorID) {
		if(musicDirectorID<=0)
			return false;
		return true;
	}

	private boolean validateName(String musicDirectorName) throws Exception {
		boolean isValid=true;
		String errorMessage="";
		if(musicDirectorName.length()<3)
		{
			errorMessage=errorMessage+"\nName Length should be minimum 3 charactes";
			isValid=false;
		}
		if(!(musicDirectorName.matches("[A-Z][A-Za-z ]{2,}")))
		{
			errorMessage=errorMessage+"\nName should start with Capital Letter and contain only alphabets";
			isValid=false;
		}
		
		if(!isValid) {
			throw new Exception(errorMessage);
		}
		return isValid;
	}

}
