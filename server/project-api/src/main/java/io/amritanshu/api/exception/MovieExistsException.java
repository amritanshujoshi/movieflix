package io.amritanshu.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class MovieExistsException extends RuntimeException{

	private static final long serialVersionUID = 7941437485979943589L;
	
	public MovieExistsException(String message) {
		super(message);
	}
	
	public MovieExistsException(String message, Throwable cause) {
		super(message, cause);
	}
	
	

}
