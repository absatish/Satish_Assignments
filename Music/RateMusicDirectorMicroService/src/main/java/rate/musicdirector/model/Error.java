package rate.musicdirector.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Error {

	int refCode;
	String summary;
	String description;
	
	public Error() {
		
	}
}
