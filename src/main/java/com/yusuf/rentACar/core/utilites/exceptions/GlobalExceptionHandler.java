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

		ProblemDetail detail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Brand already exists !!");

		return detail;

	}

	@ExceptionHandler(ModelException.class)
	public ProblemDetail modelAlreadyExistsException(ModelException e) {

		ProblemDetail detail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Model already exists !!");

		return detail;

	}

	@ExceptionHandler(CarException.class)
	public ProblemDetail carAlreadyExistsException(CarException e) {
		ProblemDetail detail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Car already exists !!");

		return detail;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ProblemDetail validException(MethodArgumentNotValidException e) {
		ProblemDetail detail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,
				"Fields cannot be null or blank");

		return detail;

	}

}
