package demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

@Repository
public class DynamoDBRepository {
	
	@Autowired
	DynamoDBMapper mapper;
	
	public Student getOneStudentDetails(int rollNumber)
	{
		return mapper.load(Student.class,rollNumber);
		
		/* *************** Alternative way *****************
		 * Student student=new Student();student.setRollno(rollNumber);
		DynamoDBQueryExpression<Student> queryExpression=new DynamoDBQueryExpression<Student>().withHashKeyValues(student);
		return mapper.query(Student.class, queryExpression);
		 * 
		 */
	}

	public List<Student> getAll() {
		return mapper.scan(Student.class, new DynamoDBScanExpression());
	}

	public boolean insertStudent(Student student) {
		mapper.save(student);
		return true;
	}

	public int updateStudent(int rollno, Student student) {
		if(student.getRollno()!=rollno)
			return 0;
		if(mapper.load(Student.class,rollno)==null)
			return -1;
		mapper.save(student);
		return 1;
	}

	public boolean deleteStudent(int rollno) {
		Student student=mapper.load(Student.class,rollno);
		mapper.delete(student);
		return true;
	}
	
	
}
