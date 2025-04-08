package com.mslearning.hotel.service.controller;

import com.mslearning.hotel.service.entities.Hotel;
import com.mslearning.hotel.service.services.Impl.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {

    @Autowired
    private HotelServiceImpl service;

    @PostMapping("/registerHotel")
    public ResponseEntity<String> registerHotel(@RequestBody Hotel hotel){
        Hotel hotel1 = service.createHotelEntry(hotel);
        if(hotel1!=null){
            return ResponseEntity.ok("Hotel Registered Successfully");
        }else {
            return ResponseEntity.badRequest().body("Hotel Not Registered");
        }
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable("hotelId") String id){
        Hotel hotel = service.getHotelById(id);
        return ResponseEntity.ok(hotel);
    }

    @GetMapping("/fetchAllHotels")
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> hotels = service.getAllHotels();
        return ResponseEntity.ok(hotels);
    }
}
