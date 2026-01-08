package com.hotel.imp.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.exception.ResourceNotFoundException;
import com.hotel.iservices.Hotel_iservices;
import com.hotel.model.hotel_model;
import com.hotel.repositroy.Hotel_Repository;

@Service
public class Hotel_imp_services implements Hotel_iservices {

    @Autowired
    private Hotel_Repository hr;

    // CREATE
    @Override
    public hotel_model create(hotel_model hotel) {
    	String hotelId=UUID.randomUUID().toString();
    	hotel.setId(hotelId);
        return hr.save(hotel);
    }

    // GET ALL
    @Override
    public List<hotel_model> getall() {
        return hr.findAll();
    }

    // GET BY ID
    @Override
    public hotel_model getid(String id) {
        return hr.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Hotel with given id not found"));
    }

    // DELETE BY ID
    @Override
    public String deleteid(String id) {
        hotel_model hotel = hr.findById(id).orElseThrow(() ->new ResourceNotFoundException("Hotel not found"));

        hr.delete(hotel);
        return "Hotel deleted successfully";
    }

    // UPDATE BY ID
    @Override
    public hotel_model updateid(String id, hotel_model hotel) {

        hotel_model existingHotel = hr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel not found"));

        existingHotel.setName(hotel.getName());
        existingHotel.setLocation(hotel.getLocation());
        existingHotel.setAbout(hotel.getAbout());

        return hr.save(existingHotel);
    }
}
