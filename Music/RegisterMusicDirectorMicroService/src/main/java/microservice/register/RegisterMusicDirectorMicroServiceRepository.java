package microservice.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

import microservice.model.MusicDirector;

@Service
public class RegisterMusicDirectorMicroServiceRepository {
	
	@Autowired
	DynamoDBMapper mapper;

	public boolean registerNewMusicDirector(MusicDirector musicDirector){
		mapper.save(musicDirector);
		return true;
	}

	public MusicDirector getMusicDirector(int ID) {
		return mapper.scan(MusicDirector.class, new DynamoDBScanExpression()).stream().filter(md->md.getMusicDirectorID()==ID).findFirst().get();
	}
}
