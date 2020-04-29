package com.consumer.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RatingDetails {
	
	int musicDirectorID;
	double rating;
	UserProfile userProfile;
	
	public RatingDetails() {}

}
