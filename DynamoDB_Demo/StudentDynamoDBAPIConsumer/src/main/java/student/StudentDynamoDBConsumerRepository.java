package student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import student.model.Marks;
import student.model.StudDetailsMarks;
import student.model.Student;


@Service
public class StudentDynamoDBConsumerRepository{

	@Autowired
	RestTemplate template;
	@Autowired
	StudentDynamoDBValidator validator;
	static final String URLSTUDENT="http://localhost:8081/student/";
	static final String URLMARKS="http://localhost:8083/marks/";

	List<Student> details;
	
	public StudentDynamoDBConsumerRepository() {
		try {
		details=Arrays.asList(template.getForObject(URLSTUDENT+"getAll",Student[].class));;
		}
		catch(NullPointerException ne)
		{
			
		}
	}
	public List<StudDetailsMarks> getAll()
	{
		List<Marks> marks=Arrays.asList(template.getForObject(URLMARKS+"getAll",Marks[].class));
	    return details.stream().map(d->{
	    	Marks mark=marks.stream().filter(m->(d.getRollNumber())==(m.getRollNumber())).findFirst().get();
	    	StudDetailsMarks total=new StudDetailsMarks();total.setStudent(d);total.setMarks(mark);return total;
	    	}).collect(Collectors.toList());
	}

	public StudDetailsMarks getOneStudentDetails(int rollNumber) {
		StudDetailsMarks student=new StudDetailsMarks();
		student.setStudent(template.getForObject(URLSTUDENT+"get/"+rollNumber, Student.class));
		student.setMarks(template.getForObject(URLSTUDENT+rollNumber,Marks.class));
		return student;
	}

	public String insertStudent(StudDetailsMarks studDetailsMarks) {
		try {
			validator.isValidToInsertStudentDetails(details,studDetailsMarks.getStudent());
			System.out.println(studDetailsMarks.getStudent());
			System.out.println(studDetailsMarks.getMarks());
			return template.postForObject(URLSTUDENT+"add", studDetailsMarks.getStudent(), String.class)+
			template.postForObject(URLMARKS+"add",studDetailsMarks.getMarks(),String.class);
		}
		catch(NullPointerException ne) {
			return ne.getLocalizedMessage();
		}
		catch(Exception e){
			return e.getLocalizedMessage();
		}
	}
	
	public String updateStudentDetails(Student student) {
		try {
			validator.isValidToUpdateStudentDetails(details,student);
			template.put(URLSTUDENT,student,student.getRollNumber());
			return "Student Details Updated Successfully..!";
		}
		catch(NullPointerException ne) {
			return ne.getLocalizedMessage();
		}
		catch(Exception ex)
		{
			return ex.getLocalizedMessage();
		}
	}
	
	public String updateStudentMarks(Marks marks) {
		try {
			validator.isValidToUpdateStudentMarks(marks);
			template.put(URLMARKS, marks,marks.getRollNumber());
			return "Student Marks Updated Successfully..!";
		}
		catch(Exception ex) {
			return ex.getLocalizedMessage();
		}
	}


	
}
