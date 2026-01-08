package com.hotel.iservices;

import java.util.List;

import com.hotel.model.hotel_model;

public interface Hotel_iservices {

	public hotel_model create(hotel_model hotel);
	
	public List<hotel_model> getall();
	
	public hotel_model getid(String id);
	
    public String deleteid(String id) ;
	
    public hotel_model updateid(String id, hotel_model hotel) ;
}
