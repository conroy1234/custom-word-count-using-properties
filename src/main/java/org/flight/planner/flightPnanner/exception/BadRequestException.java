package org.flight.planner.flightPnanner.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "BAD REQUEST")
public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = -4870315020414022274L;

	public BadRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	
	}

	public BadRequestException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public BadRequestException(String message) {
		super(message);
		
	}

	public BadRequestException(Throwable cause) {
		super(cause);
		
	}

}
