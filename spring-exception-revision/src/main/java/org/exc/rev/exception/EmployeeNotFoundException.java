package org.exc.rev.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8039243965646373502L;

	public EmployeeNotFoundException(String message) {
		super(message);

	}

}
