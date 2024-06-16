package com.ms.rating.service.services;

import java.util.List;

import com.ms.rating.service.entities.Rating;

public interface RatingService {

	Rating createRating(Rating rating);
	List<Rating> getRatings();
	List<Rating> getRatingByUserId(String userId);
	List<Rating> getRatingByHotelId(String hotelId);
	
}
