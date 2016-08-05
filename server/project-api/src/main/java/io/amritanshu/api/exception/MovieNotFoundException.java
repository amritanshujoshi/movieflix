package io.amritanshu.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 4560140946164194176L;
	
	public MovieNotFoundException(String message) {
		super(message);
	}
	
	public MovieNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
