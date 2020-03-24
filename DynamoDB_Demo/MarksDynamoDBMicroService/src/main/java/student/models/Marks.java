package student.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="Marks")
public class Marks {
	int rollNumber;
	int Telugu;
	int Hindi;
	int English;
	int Maths;
	int Science;
	int Social;
	
	public Marks() {
		super();
	}
	public Marks(int rollNumber, int telugu, int hindi, int english, int maths, int science, int social) {
		super();
		this.rollNumber = rollNumber;
		Telugu = telugu;
		Hindi = hindi;
		English = english;
		Maths = maths;
		Science = science;
		Social = social;
	}
	
	@DynamoDBHashKey(attributeName="rollNumber")
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	
	@DynamoDBAttribute(attributeName = "Telugu")
	public int getTelugu() {
		return Telugu;
	}
	public void setTelugu(int telugu) {
		Telugu = telugu;
	}
	
	@DynamoDBAttribute(attributeName = "Hindi")
	public int getHindi() {
		return Hindi;
	}
	public void setHindi(int hindi) {
		Hindi = hindi;
	}
	
	@DynamoDBAttribute(attributeName = "English")
	public int getEnglish() {
		return English;
	}
	public void setEnglish(int english) {
		English = english;
	}
	
	@DynamoDBAttribute(attributeName = "Maths")
	public int getMaths() {
		return Maths;
	}
	public void setMaths(int maths) {
		Maths = maths;
	}
	
	@DynamoDBAttribute(attributeName = "Science")
	public int getScience() {
		return Science;
	}
	public void setScience(int science) {
		Science = science;
	}
	
	@DynamoDBAttribute(attributeName = "Social")
	public int getSocial() {
		return Social;
	}
	public void setSocial(int social) {
		Social = social;
	}
	
}
