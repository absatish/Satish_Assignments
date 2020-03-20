package demo;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="students")
public class Student {
	
	
	int rollno;
	String firstName;
	String lastName;
	int marks;
	
	public Student()
	{
		
	}
	
	public Student(int rollNumber, String firstName, String lastName, int marks) {
		super();
		this.rollno = rollNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.marks = marks;
	}
	
	@DynamoDBHashKey(attributeName="rollno")
	public int getRollNumber() {
		return rollno;
	}
	
	public void setRollNumber(int rollNumber) {
		this.rollno = rollNumber;
	}
	
	@DynamoDBAttribute(attributeName="firstName")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@DynamoDBAttribute(attributeName="lastName")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@DynamoDBAttribute(attributeName="marks")
	public int getMarks() {
		return marks;
	}
	
	public void setMarks(int marks) {
		this.marks = marks;
	}
}
