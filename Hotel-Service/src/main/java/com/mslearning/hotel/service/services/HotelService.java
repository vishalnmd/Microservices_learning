package com.mslearning.hotel.service.services;

import com.mslearning.hotel.service.entities.Hotel;

import java.util.List;

public interface HotelService {

    Hotel createHotelEntry(Hotel hotel);
    List<Hotel> getAllHotels();
    Hotel getHotelById(String id);
    void deleteHotelById(String id);
    Hotel updateHotel(Hotel hotel);
}
