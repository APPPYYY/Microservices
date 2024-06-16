package com.ms.hotel.service.service;

import java.util.List;

import com.ms.hotel.service.entities.Hotel;
import com.ms.hotel.service.payload.CustomResponse;

public interface HotelService {

	Hotel createHotel(Hotel entity);
	List<Hotel> fetchAllHotels();
	Hotel fetchHotelById(String hotelId);
	Hotel updateHotelById(Hotel entity,String hotelId);
	CustomResponse deleteHotelById(String hotelId);
}
