package org.jsp.elm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class EmployeeNotFoundException extends RuntimeException {


	public EmployeeNotFoundException(String message) {
		super(message);
	}

}
