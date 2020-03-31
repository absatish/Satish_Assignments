package student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import student.model.StudDetailsMarks;
import student.model.Student;

@RestController
@RequestMapping("/student")
public class StudentDynamoDBConsumerController {

	@Autowired
	StudentDynamoDBConsumerRepository repository;
	
	@GetMapping("/getAll")
	public List<StudDetailsMarks> getAll()
	{
		return repository.getAll();
	}
	
	@GetMapping("/{rollNumber}")
	public StudDetailsMarks getOneStudentDetails(@PathVariable("rollNumber") int rollNumber)
	{
		return repository.getOneStudentDetails(rollNumber);
	}
	
	@PostMapping("/add")
	public String insertStudent(@RequestBody StudDetailsMarks studDetailsMarks) {
		return repository.insertStudent(studDetailsMarks);
	}
	
	@PutMapping("/update/details")
	public String updateStudentDetails(@RequestBody Student student) {
		return repository.updateStudentDetails(student);
	}
}
