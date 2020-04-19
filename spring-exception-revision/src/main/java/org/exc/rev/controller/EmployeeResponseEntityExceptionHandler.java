package org.exc.rev.controller;

import java.time.LocalDate;

import org.exc.rev.exception.EmployeeNotFoundException;
import org.exc.rev.model.ExceptionProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class EmployeeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	public ResponseEntity<ExceptionProvider> handleNotFoundException(EmployeeNotFoundException ex, WebRequest request){
		ExceptionProvider provider = new ExceptionProvider(ex.getMessage(),LocalDate.now(),request.getDescription(true));
		return new ResponseEntity<ExceptionProvider>(provider,HttpStatus.NOT_FOUND);
	}
}
