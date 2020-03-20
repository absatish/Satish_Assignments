package demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

@Repository
public class DynamoDBRepository {
	
	@Autowired
	DynamoDBMapper mapper;
	
	public Student getOneStudentDetails(int rollNumber)
	{
		return mapper.load(Student.class,rollNumber);
	}

	public List<Student> getAll() {
		return mapper.scan(Student.class, new DynamoDBScanExpression());
	}

	public boolean insertStudent(Student student) {
		mapper.save(student);
		return true;
	}
}
