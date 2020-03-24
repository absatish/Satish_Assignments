package com.student;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentmodels.Student;

@RestController
@RequestMapping("/student")
public class StudentMicroServiceAPIController {

	@Autowired
	StudentMicroServiceAPIRepository repository;
	
	@GetMapping("/getAll")
	public List<Student> getAll()
	{
		return repository.getAll();
	}
	
	@GetMapping("/get/{rollNumber}")
	public Student getOneStudent(@PathVariable("rollNumber") int rollNumber)
	{
		return repository.getOneStudent(rollNumber);
	}
	
	@PostMapping("/add")
	public String addStudent(@RequestBody Student student)
	{
		return repository.addStudent(student);
	}
	
	@PutMapping("/edit/{rollNumber}")
	public String updateStudent(@RequestBody Student student,@PathVariable("rollNumber") int rollNumber) {
		return repository.updateStudent(student,rollNumber);
	}
}
