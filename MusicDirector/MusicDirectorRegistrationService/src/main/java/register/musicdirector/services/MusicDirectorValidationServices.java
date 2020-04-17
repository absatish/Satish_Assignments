package register.musicdirector.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import register.musicdirector.model.MusicDirector;

@Service
public class MusicDirectorValidationServices {
	
	@Autowired
	MusicDirectorServicesRepository repository;
	
	public boolean validateMusicDirector(final MusicDirector musicDirector) {
		List<MusicDirector> musicDirectorsList = repository.getAll();
		return !musicDirectorsList.stream().anyMatch(mDirector->mDirector.getMusicDirectorID()==musicDirector.getMusicDirectorID());
	}

}
