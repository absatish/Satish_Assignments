package register.musicdirector.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

import register.musicdirector.model.MusicDirector;

@Service
public class MusicDirectorServicesRepository {
	
	@Autowired
	DynamoDBMapper mapper;
	
	@Autowired
	MusicDirectorValidationServices validations;

	public boolean registerNewMusicDirector(MusicDirector musicDirector){
		boolean isMusicDirectorAlreadyRegistered = validations.validateMusicDirector(musicDirector);
		if(isMusicDirectorAlreadyRegistered)
			mapper.save(musicDirector);
		return isMusicDirectorAlreadyRegistered;
	}

	public MusicDirector getMusicDirector(int ID) {
		return mapper.scan(MusicDirector.class, new DynamoDBScanExpression()).stream().filter(md->md.getMusicDirectorID()==ID).findFirst().get();
	}

	public List<MusicDirector> getAll() {
		
		return mapper.scan(MusicDirector.class, new DynamoDBScanExpression()).stream().collect(Collectors.toList());
		
	}
}
