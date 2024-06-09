package com.ms.rating.service.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.rating.service.entities.Rating;
import com.ms.rating.service.exceptions.BusinessException;
import com.ms.rating.service.payload.AppConstants;
import com.ms.rating.service.repo.RatingRepo;
import com.ms.rating.service.services.RatingService;

import lombok.extern.slf4j.Slf4j;

/**
 * @implSpec - Service implementation class for managing ratings.
 */
@Service
@Slf4j
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepo ratingRepo;
	
	/**
	 * @implNote - Create a new rating.
	 * @param - entity the rating entity to create
	 * @return - the created rating entity
	 */
	@Override
	public Rating createRating(Rating rating) {
		try {
			return ratingRepo.save(rating);
		} catch (Exception e) {
			log.error("{}",e);
			throw new BusinessException(AppConstants.ERR_CREATE_RATING);
		}
	}

	/**
	  * @implNote - Fetch all ratings.
	  * @return - a list of all rating entities
	  */
	@Override
	public List<Rating> getRatings() {
		try {
			return ratingRepo.findAll();
		} catch (Exception e) {
			log.error("{}",e);
			throw new BusinessException(AppConstants.ERR_FETCH_ALL_RATING);
		}
	}

	/**
     * @implNote - Fetch ratings by user ID.
     * 
     * @param userId the ID of the user to fetch ratings
     * @return List<Rating> corresponding to the given user ID, or null if not found
     */
	@Override
	public List<Rating> getRatingByUserId(String userId) {
		try {
			return ratingRepo.findByUserId(userId);
		} catch (Exception e) {
			log.error("{}",e);
			throw new BusinessException(AppConstants.ERR_FETCH_RATINGS_BY_USER_BY_ID);
		}
	}

	/**
     * @implNote - Fetch ratings by hotel ID.
     * 
     * @param hotelId the ID of the Hotel to fetch ratings
     * @return List<Rating> corresponding to the given hotel ID, or null if not found
     */
	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		try {
			return ratingRepo.findByHotelId(hotelId);
		} catch (Exception e) {
			log.error("{}",e);
			throw new BusinessException(AppConstants.ERR_FETCH_RATINGS_BY_HOTEL_BY_ID);
		}
	}

}
