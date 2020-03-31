package student.model;

import java.util.List;

public abstract class Validations {
	public abstract void isValidToInsertStudentDetails(List<Student> details,Student student) throws Exception;
	public abstract void isValidToUpdateStudentDetails(List<Student> details,Student student) throws Exception;
	public abstract void isValidToInsertStudentMarks(Marks marks) throws Exception;
	public abstract void isValidToUpdateStudentMarks(List<Student> details,Marks marks) throws Exception;
}
