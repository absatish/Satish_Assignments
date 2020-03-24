package student.marks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

import student.models.Marks;

@Service
public class MarksDynamoDBAPIRepository {
	@Autowired
	DynamoDBMapper mapper;
	public List<Marks> getAll()
	{
		return mapper.scan(Marks.class,new DynamoDBScanExpression());
	}
	
	public Marks getOneStudentMarks(int rollNumber)
	{
		return mapper.load(Marks.class,rollNumber);
	}
	
	public String insertMarks(Marks marks)
	{
		mapper.batchSave(marks);
		return "Marks Entered Successfully..!";
	}
}
