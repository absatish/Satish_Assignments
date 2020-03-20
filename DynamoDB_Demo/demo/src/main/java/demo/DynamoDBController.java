package demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dynamodb")
public class DynamoDBController {

	@Autowired
	private DynamoDBRepository repository;
	
	@GetMapping("/{rollnumber}")
	public ResponseEntity<Student> getOneStudentDetails(@PathVariable("rollnumber") int rollnumber){
		Student student=repository.getOneStudentDetails(rollnumber);
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public List<Student> getAll()
	{
		List<Student> students=repository.getAll();
		return students;
	}
	
	@PostMapping("/save")
	public String insertStudent(@RequestBody Student student) {
		if(repository.insertStudent(student))
			return student.getFirstName()+" "+student.getLastName()+" added Successfully..!";
		return "Can't add "+student.getFirstName()+" "+student.getLastName();
	}
	
}
