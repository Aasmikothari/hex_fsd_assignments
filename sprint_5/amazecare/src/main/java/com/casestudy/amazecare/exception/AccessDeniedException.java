package com.casestudy.amazecare.exception;

/**
 * Thrown when a user tries to access something they are not authorized to.
 */
public class AccessDeniedException extends RuntimeException {
    
	private static final long serialVersionUID = 1L;

	public AccessDeniedException(String message) {
		super(message);
	}
}
