package student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student.model.Marks;
import student.model.Student;
import student.model.Validations;

@Service
public class StudentDynamoDBValidator extends Validations {
	
	@Autowired
	StudentDynamoDBExceptions exceptions;

	@Override
	public void isValidToInsertStudentDetails(List<Student> details,Student student) throws Exception
	{
		checkName(student.getfName(),student.getlName());
		
		checkPincode(student.getAddress().getPincode());
	
		checkRollNumber(details,student.getRollNumber());
		
		checkPhoneNumber(student.getPhoneNumber());
	}

	@Override
	public void isValidToUpdateStudentDetails(List<Student> details,Student student) throws Exception
	{
		if(!details.stream().anyMatch(s->s.getRollNumber()==student.getRollNumber()))
			exceptions.rollNumberAlreadyExists("Roll Number not found : "+student.getRollNumber());
		
		checkName(student.getfName(),student.getlName());
		
		checkPincode(student.getAddress().getPincode());
	}
	
	@Override
	public void isValidToInsertStudentMarks(Marks marks) throws Exception {
		if(!((marks.getTelugu()>=0 && marks.getTelugu()<=100)
				&& (marks.getHindi()>=0 && marks.getHindi()<=100)
				&& (marks.getEnglish()>=0 && marks.getEnglish()<=100)
				&& (marks.getMaths()>=0 && marks.getMaths()<=100)
				&& (marks.getScience()>=0 && marks.getScience()<=100)
				&& (marks.getSocial()>=0 && marks.getSocial()<=100)))
			exceptions.marksInvalidException("Invalid Marks (100Marks>=0 )");	
	}
	
	@Override
	public void isValidToUpdateStudentMarks(List<Student> details,Marks marks) throws Exception {
		if(details.stream().anyMatch(s->s.getRollNumber()==marks.getRollNumber()))
			throw new Exception("Roll Number not found : "+marks.getRollNumber());
	}
	
	private void checkRollNumber(List<Student> details,int rollNumber) throws Exception {
		if(details.stream().anyMatch(s->s.getRollNumber()==rollNumber))
			exceptions.rollNumberAlreadyExists("Roll Number already Exists..!");
		
		if(rollNumber==0)
			exceptions.rollNumberInvalidException("Invalid Roll Number..!");
		
	}
	
	private void checkName(String fName,String lName) throws Exception
	{
		if(fName.isEmpty() || fName.equals(null) || lName.isEmpty() || lName.equals(null))
			throw new NullPointerException("First/Last Name Can't be Null/Empty");
		if(!(fName.matches("[A-Z][A-Za-z]{2,}"))) {
			//System.out.println(fName.matches("[A-Z][A-Za-z]{2,}"));
			throw new Exception("First name is not in required format Eg: Satish/SATISH should contain atleast three characters");
		}
		if(!(lName.matches("[A-Z][A-Za-z]{2,}"))) {
			//System.out.println(fName.matches("[A-Z][A-Za-z]{2,}"));
			throw new Exception("Last name is not in required format Eg: Jajula/JAJULA should contain atleast three characters");
		}
	}
	
	private void checkPhoneNumber(long phoneNumber) throws Exception {
		if(!String.valueOf(phoneNumber).matches("[6-9][0-9]{9}")) //Regular Expression to validate phone number
			exceptions.phoneNumberNotValidException("Invalid PhoneNumber..!");
	}
	
	private void checkPincode(int pincode) throws Exception {
		if(!String.valueOf(pincode).matches("[1-9]{6}"))
			exceptions.pincodeInvalidException("Invalid Pincode : "+pincode);	
	}
	
}
