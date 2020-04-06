package com.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class MusicDirector {
	
	int musicDirectorID;
	String musicDirectorName;
	int noOfMovies;
}
