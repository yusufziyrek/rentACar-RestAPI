package com.yusuf.rentACar.core.utilites.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BrandException.class)
	public ProblemDetail brandAlreadyExistsException(BrandException e) {

		ProblemDetail detail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());

		return detail;

	}

	@ExceptionHandler(ModelException.class)
	public ProblemDetail modelAlreadyExistsException(ModelException e) {

		ProblemDetail detail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());

		return detail;

	}

	@ExceptionHandler(CarException.class)
	public ProblemDetail carAlreadyExistsException(CarException e) {
		ProblemDetail detail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());

		return detail;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ProblemDetail validException(MethodArgumentNotValidException e) {
		ProblemDetail detail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Invalid value !!");

		return detail;

	}

}
