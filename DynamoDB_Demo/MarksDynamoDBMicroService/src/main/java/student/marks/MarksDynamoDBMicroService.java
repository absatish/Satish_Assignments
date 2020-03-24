package student.marks;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarksDynamoDBMicroService {
	
	public static void main(String[] args) {
		SpringApplication.run(MarksDynamoDBMicroService.class, args);
	}
}
