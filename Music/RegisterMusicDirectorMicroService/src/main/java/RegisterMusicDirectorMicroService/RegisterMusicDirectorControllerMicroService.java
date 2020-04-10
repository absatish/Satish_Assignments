package RegisterMusicDirectorMicroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import microservice.model.MusicDirector;
import microservice.register.RegisterMusicDirectorMicroServiceRepository;

@RestController
@RequestMapping("/")
public class RegisterMusicDirectorControllerMicroService{

	@Autowired
	RegisterMusicDirectorMicroServiceRepository repository;
	
	@Autowired
	AWSCredentialsProvider cred;
	
	
	@GetMapping("/home")
	public String homePage() {
		return cred.getCredentials().getAWSAccessKeyId();
		//return "Welcome to Registration MicroService HomePage..!";
	}
	
	@PostMapping("/register")
	public boolean regMusicDirector(@RequestBody MusicDirector musicDirector){
		return repository.registerNewMusicDirector(musicDirector);
	}
	
}
