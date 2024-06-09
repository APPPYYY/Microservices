package com.ms.user.service.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ms.user.service.entities.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

	@GetMapping("/ms/hotels/{hotelId}")
	Hotel getHotelByHotelId(@PathVariable("hotelId") String hotelId);
}
