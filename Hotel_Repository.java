package com.hotel.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.model.hotel_model;

public interface Hotel_Repository extends JpaRepository<hotel_model,String> {

}
