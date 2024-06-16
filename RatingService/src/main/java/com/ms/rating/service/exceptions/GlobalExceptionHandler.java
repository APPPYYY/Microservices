package com.ms.rating.service.exceptions;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ErrorResponse> handlerBusinessException(BusinessException bx) {
		ErrorResponse response = ErrorResponse.builder().message(bx.getMessage()).timeStamp(LocalDateTime.now()).errorCode(UUID.randomUUID().toString()).build();
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
}
