package org.flight.planner.flightPnanner.api.exception;

import java.util.Date;

import org.flight.planner.flightPnanner.exception.BadRequestException;
import org.flight.planner.flightPnanner.exception.ExceptionResponse;
import org.flight.planner.flightPnanner.exception.FlightNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class FlightResponseEntityExceptionHaldler extends ResponseEntityExceptionHandler {
	

	@ExceptionHandler(FlightNotFoundException.class)
	public final ResponseEntity<Object> handleNotFoundException(FlightNotFoundException ex, WebRequest request){
		ExceptionResponse exceptionResponse =new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(true));
		
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public final ResponseEntity<Object> handleBadRequestFoundException(BadRequestException ex, WebRequest request){
		ExceptionResponse exceptionResponse =new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(true));
		
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}
