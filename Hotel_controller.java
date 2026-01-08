package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.imp.services.Hotel_imp_services;
import com.hotel.model.hotel_model;

@RestController
@RequestMapping("/hotels")
public class Hotel_controller {
@Autowired
	private Hotel_imp_services hs;
@PostMapping
public ResponseEntity<hotel_model> createhotel(@RequestBody hotel_model hotel){
	return ResponseEntity.status(HttpStatus.CREATED).body(hs.create(hotel));
}
@GetMapping("/{hotelid}")
public  ResponseEntity<hotel_model> getbyid(@PathVariable String hotelid){
	return ResponseEntity.status(HttpStatus.OK).body(hs.getid(hotelid));
}
@GetMapping
public ResponseEntity<List<hotel_model>> getAll(){
	return ResponseEntity.ok(hs.getall());
}
@PutMapping("/{hotelid}")
public ResponseEntity<hotel_model> updatebyid(@PathVariable String hotelid ,@RequestBody hotel_model hotel){
	return ResponseEntity.ok(hs.updateid(hotelid, hotel));
}
@DeleteMapping("/{hotelid}")
public ResponseEntity<String> deletebyid(@PathVariable String hotelid){
	return ResponseEntity.ok(hs.deleteid(hotelid));
}
}
