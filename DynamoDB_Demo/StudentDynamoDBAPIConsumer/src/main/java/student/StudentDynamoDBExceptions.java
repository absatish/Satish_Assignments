package student;

import org.springframework.stereotype.Service;

@Service
public class StudentDynamoDBExceptions extends Exception {

	public void phoneNumberNotValidException(String str) throws Exception
	{
		throw new Exception(str);
	}
	
	public void rollNumberInvalidException(String str) throws Exception
	{
		throw new Exception(str);
	}

	public void rollNumberAlreadyExists(String string) throws Exception {
		throw new Exception(string);
		
	}

	public void pincodeInvalidException(String string) throws Exception{
		throw new Exception(string);
	}

	public void marksInvalidException(String string) throws Exception {
		throw new Exception(string);
		
	}
}
