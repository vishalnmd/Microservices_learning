package com.mslearning.hotel.service.services.Impl;

import com.mslearning.hotel.service.entities.Hotel;
import com.mslearning.hotel.service.exceptions.ResourceNotFoundException;
import com.mslearning.hotel.service.repositories.HotelRepository;
import com.mslearning.hotel.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository repository;

    @Override
    public Hotel createHotelEntry(Hotel hotel) {
        UUID uuid = UUID.randomUUID();
        hotel.setId(uuid.toString());
        return repository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return repository.findAll();
    }

    @Override
    public Hotel getHotelById(String id) {
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel not found for this id :: "+id));
    }

    @Override
    public void deleteHotelById(String id) {
        repository.deleteById(id);
    }

    @Override
    public Hotel updateHotel(Hotel hotel) {
        return repository.save(hotel);
    }
}
