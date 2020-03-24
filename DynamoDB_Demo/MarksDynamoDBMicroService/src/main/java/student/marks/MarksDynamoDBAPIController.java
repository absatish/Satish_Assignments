package student.marks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import student.models.Marks;

@RestController
@RequestMapping("/marks")
public class MarksDynamoDBAPIController {
	
	@Autowired
	MarksDynamoDBAPIRepository repository;
	
	@GetMapping("/getAll")
	public List<Marks> getAll()
	{
		return repository.getAll();
	}
	
	@GetMapping("/{rollNumber}")
	public Marks getOneStudentMarks(@PathVariable("rollNumber") int rollNumber) {
		return repository.getOneStudentMarks(rollNumber);
	}
	
	@PostMapping("/add")
	public String insertMarks(@RequestBody Marks marks)
	{
		return repository.insertMarks(marks);
	}
}
