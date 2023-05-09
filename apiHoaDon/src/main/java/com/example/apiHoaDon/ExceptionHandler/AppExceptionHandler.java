package com.example.apiHoaDon.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ObjectNotFoundException.class)
	public Map<String, String> handleObjectNotFoundException(ObjectNotFoundException ex){
		Map<String, String> errors = new HashMap<>();
		errors.put("ErrorMessage", ex.getMessage());
		return errors;
	}
}
