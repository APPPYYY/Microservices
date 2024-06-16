package com.ms.hotel.service.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ms/staffs")
public class StaffController {

	@GetMapping("/")
	public ResponseEntity<List<String>> getAllStaffs(){
		List<String> list = Arrays.asList("Ram","Gita","Shyam","Sundar");
		return ResponseEntity.ok(list);
	}
}
