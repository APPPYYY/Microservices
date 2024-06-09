package com.ms.hotel.service.payload;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomResponse {

	private String project;
	private String message;
	private String solution;
	private HttpStatus status;
}
