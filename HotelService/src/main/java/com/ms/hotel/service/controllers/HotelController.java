package com.ms.hotel.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.hotel.service.entities.Hotel;
import com.ms.hotel.service.payload.CustomResponse;
import com.ms.hotel.service.service.HotelService;

@RestController
@RequestMapping("/ms/hotels")
public class HotelController {

	@Autowired
	private HotelService service;
	
	@PreAuthorize("hasAuthority('Admin')")
	@PostMapping("/")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel entity){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createHotel(entity));
	}
	@PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
	@GetMapping("/")
	public ResponseEntity<List<Hotel>> fetchAllHotels(){
		return ResponseEntity.status(HttpStatus.OK).body(service.fetchAllHotels());
	}
	@PreAuthorize("hasAuthority('SCOPE_internal')")
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> fetchHotelById(@PathVariable("hotelId") String hotelId){
		return ResponseEntity.status(HttpStatus.OK).body(service.fetchHotelById(hotelId));
	}
	@PutMapping("/{hotelId}")
	public ResponseEntity<Hotel> updateHotelById(
			@RequestBody Hotel entity,
			@PathVariable("hotelId") String hotelId){
		return ResponseEntity.status(HttpStatus.OK).body(service.updateHotelById(entity,hotelId));
	}
	
	@DeleteMapping("/{hotelId}")
	public CustomResponse deleteHotelById(@PathVariable("hotelId") String hotelId){
		return service.deleteHotelById(hotelId);
	}
}
