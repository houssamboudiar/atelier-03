package com.realestate.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ErrorHandlingController {

	// The 404 Exception
	@ExceptionHandler(NoHandlerFoundException.class)
	public String NotFoundPage(HttpServletRequest request) {
		System.out.println("This is 404");
		return "404";
	}
}
