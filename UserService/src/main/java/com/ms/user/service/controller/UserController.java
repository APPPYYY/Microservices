package com.ms.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.user.service.entities.User;
import com.ms.user.service.payload.CustomResponse;
import com.ms.user.service.service.UserService;

@RestController
@RequestMapping("/ms/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/")
	public ResponseEntity<User> createUser(@RequestBody User entity){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(entity));
	}
	
	@GetMapping("/")
	public ResponseEntity<List<User>> fetchAllUsers(){
		return ResponseEntity.status(HttpStatus.OK).body(service.fetchAllUsers());
	}
	@GetMapping("/{userId}")
	public ResponseEntity<User> fetchUserById(@PathVariable("userId") String userId){
		return ResponseEntity.status(HttpStatus.OK).body(service.fetchUserById(userId));
	}
	@PutMapping("/{userId}")
	public ResponseEntity<User> updateUserById(
			@RequestBody User entity,
			@PathVariable("userId") String userId){
		return ResponseEntity.status(HttpStatus.OK).body(service.updateUserById(entity, userId));
	}
	@DeleteMapping("/{userId}")
	public CustomResponse deleteUserById(@PathVariable("userId") String userId){
		return service.deleteUserById(userId);
	}

}
