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

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

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
	int retryCount=1;
	@GetMapping("/{userId}")
	//@CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
	//@Retry(name = "ratingHotelService",fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name = "userRateLimiter",fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> fetchUserById(@PathVariable("userId") String userId){
		System.out.println("RETRY COUNT - "+retryCount);
		retryCount++;
		return ResponseEntity.status(HttpStatus.OK).body(service.fetchUserById(userId));
	}
	 // Implementation for fallback method 
	public ResponseEntity<User> ratingHotelFallback(String userId,Exception ex){
		User user=User.builder().userId(userId).name("Default Name").email("default@example.com").about("This is a fallback user due to service unavailability").build();
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(user);
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
