package com.leo.spring1.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class Spring1ExceptionHandler {
	@ExceptionHandler(value=Exception.class)
	public String globalExceptionHandler(Exception e) {
		e.printStackTrace();  // should be present lest it generate exception
		return "<h1>" + e.getMessage() + "</h1>";
	}
}
