package com.ms.rating.service.exceptions;

public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinessException(String message) {
		 super(message);
	}
	
	public BusinessException() {
		super("Business exception occured !!!");
	}
}

