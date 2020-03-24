package com.studentmodels;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="Address")
public class Address {
	int rollNumber;
	String street;
	String city;
	String state;
	String country;
	int pincode;
	public Address() {
		
	}
	public Address(int rollNumber,String street, String city, String state, String country, int pincode) {
		super();
		this.rollNumber=rollNumber;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}
	
	@DynamoDBHashKey(attributeName = "rollNumber")
	public int getRollNumber()
	{
		return rollNumber;
	}
	public void setRollNumber(int rollNumber)
	{
		this.rollNumber=rollNumber;
	}
	@DynamoDBAttribute(attributeName = "street")
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	@DynamoDBAttribute(attributeName = "city")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@DynamoDBAttribute(attributeName = "state")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@DynamoDBAttribute(attributeName = "country")
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@DynamoDBAttribute(attributeName = "pincode")
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
}
