package com.ms.user.service.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ms.user.service.entities.Hotel;
import com.ms.user.service.entities.Rating;
import com.ms.user.service.entities.User;
import com.ms.user.service.exceptions.BusinessException;
import com.ms.user.service.external.services.HotelService;
import com.ms.user.service.external.services.RatingService;
import com.ms.user.service.payload.AppConstants;
import com.ms.user.service.payload.CustomResponse;
import com.ms.user.service.repo.UserRepo;
import com.ms.user.service.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @implSpec - Service implementation class for managing users.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo repo;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private HotelService hotelService;
	@Autowired
	private RatingService ratingService;
	
	/**
	 * @implNote - Create a new user.
	 * @param - entity the user entity to create
	 * @return - the created user entity
	 */
	@Override
	public User createUser(User entity) {
		try {
			entity.setUserId(UUID.randomUUID().toString());
			return repo.save(entity);
		} catch (Exception e) {
			log.error("{}",e);
			throw new BusinessException(AppConstants.ERR_CREATE_USER);
		}
	}

	/**
	  * @implNote - Fetch all users.
	  * @return - a list of all user entities
	  */
	@Override
	public List<User> fetchAllUsers() {
		try {
			return repo.findAll();
		} catch (Exception e) {
			log.error("{}",e);
			throw new BusinessException(AppConstants.ERR_FETCH_ALL_USER);
		}
	}

	/**
     * @implNote - Fetch a user by ID.
     * 
     * @param userId the ID of the user to fetch
     * @return the user entity corresponding to the given ID, or null if not found
     */
	@Override
	public User fetchUserById(String userId) {
		try {
			/**
			 * fetching user details by user id
			 */
			User user = repo.findById(userId).orElseThrow(()->new BusinessException(AppConstants.ERR_USER_NOT_FOUND+userId));
			/**
			 * fetching ratings by user id by calling Rating Service
			 */
			/* ----------------RestTemplate------------------- */
			/*
			 * Rating[] ratingsArr =
			 * restTemplate.getForObject("http://RATING-SERVICE/ms/ratings/user/"+user.
			 * getUserId(), Rating[].class);//using restTemplate List<Rating> ratingList =
			 * Arrays.stream(ratingsArr).toList();
			 */
			/* -------------------FeignClient------------------ */
			List<Rating> ratingList = ratingService.getRatingsByUserId(user.getUserId());
			List<Rating> finalRatingList = ratingList.stream().map(rating->{
				/**
				 * fetching hotel details by hotel id by calling Hotel Service
				 */
				/* ----------------RestTemplate------------------- */
				/*
				 * ResponseEntity<Hotel> forEntity =
				 * restTemplate.getForEntity("http://HOTEL-SERVICE/ms/hotels/"+rating.getHotelId
				 * (), Hotel.class);//using restTemplate Hotel hotel = forEntity.getBody();
				 */
				/* -------------------FeignClient------------------ */
				Hotel hotel = hotelService.getHotelByHotelId(rating.getHotelId());//using Feign Client
				rating.setHotel(hotel);
				return rating;
			}).collect(Collectors.toList());
			user.setRatings(finalRatingList);
			return user;
		} catch (Exception e) {
			log.error("{}",e);
			throw new BusinessException(AppConstants.ERR_FETCH_USER_BY_ID);
		}
	}

	/**
     *@implNote - Update a user by ID.
     * 
     * @param userId the ID of the user to update
     * @return the updated user entity
     */
	@Override
	public User updateUserById(User entity,String userId) {
		try {
			User user = this.fetchUserById(userId);
			if(!Objects.isNull(entity.getName())) {
				user.setName(entity.getName());
			}
			if(!Objects.isNull(entity.getEmail())) {
				user.setEmail(entity.getEmail());
			}
			if(!Objects.isNull(entity.getAbout())) {
				user.setAbout(entity.getAbout());
			}
			return repo.save(user);
		} catch (Exception e) {
			log.error("{}",e);
			throw new BusinessException(AppConstants.ERR_UPDATE_USER_BY_ID);
		}
	}

	/**
     *@implNote - Delete a user by ID.
     * 
     * @param userId the ID of the user to delete
     * @return a custom response indicating the result of the delete operation
     */
	@Override
	public CustomResponse deleteUserById(String userId) {
		try {
			User user = this.fetchUserById(userId);
				repo.delete(user);
				return new CustomResponse(AppConstants.APP_NAME, AppConstants.USER_DELETE_SUCCESS, AppConstants.NO_SOLUTION, HttpStatus.NO_CONTENT);
			
		} catch (Exception e) {
			log.error("{}",e);
			throw new BusinessException(AppConstants.ERR_DELETE_USER_BY_ID);
		}
	}

}
