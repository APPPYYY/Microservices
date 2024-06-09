package com.ms.hotel.service.exceptions;

public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinessException() {
		super("Business exception occured");
	}
	
	public BusinessException(String message) {
		super(message);
	}
}
