package com.ms.rating.service.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ms.rating.service.entities.Rating;

public interface RatingRepo extends MongoRepository<Rating, String> {

	List<Rating> findByUserId(String userId);
	List<Rating> findByHotelId(String hotelId);
}
