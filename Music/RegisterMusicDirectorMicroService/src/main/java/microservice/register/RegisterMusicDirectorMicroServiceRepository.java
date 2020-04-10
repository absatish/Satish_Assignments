package microservice.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import microservice.model.MusicDirector;

@Service
public class RegisterMusicDirectorMicroServiceRepository {
	
	@Autowired
	DynamoDBMapper mapper;

	public boolean registerNewMusicDirector(MusicDirector musicDirector){
		System.out.println(musicDirector.getMusicDirectorID());
		mapper.save(musicDirector);
		return true;
	}
}
