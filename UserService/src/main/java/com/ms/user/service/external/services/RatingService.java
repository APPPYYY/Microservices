package com.ms.user.service.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.ms.user.service.entities.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

	@GetMapping("/ms/ratings/user/{userId}")
	List<Rating> getRatingsByUserId(@PathVariable("userId") String userId);
	
	@PostMapping("/ms/ratings/")
	ResponseEntity<Rating> createRating(Rating rating);
	
	@PutMapping("/ms/ratings/{ratingId}")
	ResponseEntity<Rating> updateRatingByRatingId(@PathVariable("ratingId") String ratingId,Rating rating);
	
	@DeleteMapping("/ms/ratings/{ratingId}")
	ResponseEntity<String> deleteRatingByRatingId(@PathVariable("ratingId") String ratingId);
}
