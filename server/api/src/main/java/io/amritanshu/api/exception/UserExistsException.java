package io.amritanshu.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class UserExistsException extends RuntimeException{

	private static final long serialVersionUID = -7706774887174686475L;
	
	public UserExistsException(String message) {
		super(message);
	}
	
	public UserExistsException(String message, Throwable cause) {
		super(message, cause);
	}

}
