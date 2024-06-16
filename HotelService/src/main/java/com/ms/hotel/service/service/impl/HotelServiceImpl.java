package com.ms.hotel.service.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ms.hotel.service.entities.Hotel;
import com.ms.hotel.service.exceptions.BusinessException;
import com.ms.hotel.service.payload.AppConstants;
import com.ms.hotel.service.payload.CustomResponse;
import com.ms.hotel.service.repo.HotelRepo;
import com.ms.hotel.service.service.HotelService;

import lombok.extern.slf4j.Slf4j;
/**
 * @implSpec - Service implementation class for managing hotels 
 */
@Service
@Slf4j
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepo repo;

	/**
	 * @implNote - Create a new hotel.
	 * @param - entity the hotel entity to create
	 * @return - the created hotel entity
	 */
	@Override
	public Hotel createHotel(Hotel entity) {
		try {
			entity.setHotelId(UUID.randomUUID().toString());
			return repo.save(entity);
		} catch (Exception e) {
			log.error("{}",e);
			throw new BusinessException(AppConstants.ERR_CREATE_HOTEL);
		}
	}

	/**
	  * @implNote - Fetch all hotels.
	  * @return - a list of all hotel entities
	  */
	@Override
	public List<Hotel> fetchAllHotels() {
		try {
			return repo.findAll();
		} catch (Exception e) {
			log.error("{}",e);
			throw new BusinessException(AppConstants.ERR_FETCH_ALL_HOTEL);
		}
	}

	/**
     * @implNote - Fetch a hotel by ID.
     * 
     * @param hotelId the ID of the hotel to fetch
     * @return the hotel entity corresponding to the given ID, or null if not found
     */
	@Override
	public Hotel fetchHotelById(String hotelId) {
		try {
			return repo.findById(hotelId).orElseThrow(()->new BusinessException(AppConstants.ERR_HOTEL_NOT_FOUND+hotelId));
		} catch (Exception e) {
			log.error("{}",e);
			throw new BusinessException(AppConstants.ERR_FETCH_HOTEL_BY_ID);
		}
	}

	/**
     *@implNote - Update a hotel by ID.
     * 
     * @param hotelId the ID of the hotel to update
     * @return the updated hotel entity
     */
	@Override
	public Hotel updateHotelById(Hotel entity, String hotelId) {
		try {
			Hotel hotel = this.fetchHotelById(hotelId);
			if(!Objects.isNull(entity.getName())) {
				hotel.setName(entity.getName());
			}
			if(!Objects.isNull(entity.getLocation())) {
				hotel.setLocation(entity.getLocation());
			}
			if(!Objects.isNull(entity.getAbout())) {
				hotel.setAbout(entity.getAbout());
			}
			return repo.save(hotel);
			
		} catch (Exception e) {
			log.error("{}",e);
			throw new BusinessException(AppConstants.ERR_UPDATE_HOTEL_BY_ID);
		}
	}

	/**
     *@implNote - Delete a hotel by ID.
     * 
     * @param hotelId the ID of the hotel to delete
     * @return a custom response indicating the result of the delete operation
     */
	@Override
	public CustomResponse deleteHotelById(String hotelId) {
		try {
			Hotel hotel = this.fetchHotelById(hotelId);
			repo.delete(hotel);
			return new CustomResponse(AppConstants.APP_NAME, AppConstants.HOTEL_DELETE_SUCCESS, AppConstants.NO_SOLUTION, HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error("{}",e);
			throw new BusinessException(AppConstants.ERR_DELETE_HOTEL_BY_ID);
		}
	}

}
