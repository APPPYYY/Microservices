package com.ms.hotel.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.hotel.service.entities.Hotel;

public interface HotelRepo extends JpaRepository<Hotel ,String> {

}
