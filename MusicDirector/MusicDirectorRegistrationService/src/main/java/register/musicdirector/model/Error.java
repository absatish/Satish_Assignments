package register.musicdirector.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Error {

	int refCode;
	String summary;
	String description;
	
	public Error() {}
}
