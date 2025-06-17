package com.casestudy.amazecare.exception;

/**
 * Custom exception for handling bad requests like invalid inputs, failed validations, etc.
 */
public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BadRequestException(String message) {
		super(message);
	}
}