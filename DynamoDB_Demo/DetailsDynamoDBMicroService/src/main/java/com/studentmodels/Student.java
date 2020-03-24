package com.studentmodels;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="Student_Table")
public class Student {

	int rollNumber;
	String fName;
	String lName;
	Address address;
	long phoneNumber;
	
	public Student() {
		super();
	}

	public Student(int rollNumber, String fName, String lName, Address address, long phoneNumber) {
		super();
		this.rollNumber = rollNumber;
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	@DynamoDBHashKey(attributeName="rollNumber")
	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	
	@DynamoDBAttribute(attributeName="fName")
	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}
	
	@DynamoDBAttribute(attributeName = "lName")
	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	@DynamoDBIgnore
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		address.rollNumber=rollNumber;
		this.address = address;
	}

	@DynamoDBAttribute(attributeName = "phoneNumber")
	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
