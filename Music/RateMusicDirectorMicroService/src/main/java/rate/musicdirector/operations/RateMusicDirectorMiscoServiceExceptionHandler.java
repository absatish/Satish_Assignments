package rate.musicdirector.operations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import rate.musicdirector.model.Error;

@ControllerAdvice
public class RateMusicDirectorMiscoServiceExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<Object> raiseSimpleException(final Exception ex,final WebRequest wr){
		HttpStatus status=HttpStatus.BAD_REQUEST;
		return ResponseEntity.status(status).body(new Error(ex.hashCode(),ex.getMessage(),ex.getLocalizedMessage()));
	}

}
