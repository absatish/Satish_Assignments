package student;

import java.util.ArrayList;
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
public class StudentDynamoDBConsumerRepository {

	@Autowired
	RestTemplate template;
	
	public List<StudDetailsMarks> getAll()
	{
		List<Student> details=Arrays.asList(template.getForObject("http://localhost:8081/student/getAll",Student[].class));
		List<Marks> marks=Arrays.asList(template.getForObject("http://localhost:8083/marks/getAll",Marks[].class));
	    
	    return details.stream().map(d->{
	    	Marks mark=marks.stream().filter(m->(d.getRollNumber())==(m.getRollNumber())).findFirst().get();
	    	StudDetailsMarks total=new StudDetailsMarks();total.setStudent(d);total.setMarks(mark);return total;
	    	}).collect(Collectors.toList());
	}

	public StudDetailsMarks getOneStudentDetails(int rollNumber) {
		StudDetailsMarks student=new StudDetailsMarks();
		student.setStudent(template.getForObject("http://localhost:8081/student/get/"+rollNumber, Student.class));
		student.setMarks(template.getForObject("http://localhost:8083/marks/"+rollNumber,Marks.class));
		return student;
	}

	public String insertStudent(StudDetailsMarks studDetailsMarks) {
		System.out.println(studDetailsMarks.getStudent());
		System.out.println(studDetailsMarks.getMarks());
		return template.postForObject("http://localhost:8081/student/add", studDetailsMarks.getStudent(), String.class)+
		template.postForObject("http://localhost:8083/marks/add",studDetailsMarks.getMarks(),String.class);
	}
}
