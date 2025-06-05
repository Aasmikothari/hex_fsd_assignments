package com.casestudy.amazecare.exception;

/**
 * Custom exception for handling invalid IDs or missing resources.
 */
public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private String message;

	public ResourceNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	} 
	
	
}