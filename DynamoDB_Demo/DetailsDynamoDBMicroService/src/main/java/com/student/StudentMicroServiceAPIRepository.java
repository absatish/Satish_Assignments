package com.student;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.studentmodels.Address;
import com.studentmodels.Student;

@Repository
public class StudentMicroServiceAPIRepository {

	@Autowired
	DynamoDBMapper mapper;
	
	public List<Student> getAll()
	{
		return mapper.scan(Student.class,new DynamoDBScanExpression()).stream().map(s->{s.setAddress(mapper.load(Address.class, s.getRollNumber()));return s;}).collect(Collectors.toList());
	}

	public Student getOneStudent(int rollNumber)
	{
		Student student=mapper.load(Student.class,rollNumber);
		student.setAddress(mapper.load(Address.class,rollNumber));
		return student;
	}
	public String addStudent(Student student) {
		mapper.save(student);
		mapper.save(student.getAddress());
		return "Student Added Successfully..!";
	}

	public String updateStudent(Student student, int rollNumber) {
		mapper.save(student);
		mapper.save(student.getAddress());
		return "Student Details Updated Successfully..!";
	}
	
	
	
	
}
