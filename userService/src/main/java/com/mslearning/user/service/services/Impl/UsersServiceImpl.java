package com.mslearning.user.service.services.Impl;

import com.mslearning.user.service.entities.Hotel;
import com.mslearning.user.service.entities.Rating;
import com.mslearning.user.service.entities.Users;
import com.mslearning.user.service.exceptions.ResourceNotFoundException;
import com.mslearning.user.service.repositories.UsersRepository;
import com.mslearning.user.service.services.HotelService;
import com.mslearning.user.service.services.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class UsersServiceImpl implements UsersService {

    Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HotelService hotelService;

    @Override
    public Users createUser(Users user) {
        UUID uuid = UUID.randomUUID();
        user.setId(uuid.toString());
        return usersRepository.save(user);
    }

    @Override
    public Users getUserById(String id) {
       Users user = usersRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found"));
        Rating[] ratings = restTemplate.getForObject("http://HOTEL-SERVICE/getRatings/"+user.getId(),Rating[].class);
        List<Rating> ratingsList = Arrays.stream(ratings).toList();
        if(!ratingsList.isEmpty()){
            ratingsList.forEach(rating ->{
                //Hotel hotel = restTemplate.getForObject("http://HOTEL-SERVICE/hotel/"+rating.getHotelId(), Hotel.class);
                Hotel hotel = hotelService.getHotel(rating.getHotelId());
                rating.setHotel(hotel);
            });
        }
        user.setRatings(ratingsList);
       return user;
    }

    @Override
    public List<Users> getAllUsers() {
        List<Users> usrLst = usersRepository.findAll();

        if(!usrLst.isEmpty()){
            usrLst.forEach(usr->{
                ArrayList<Rating> ratingsList = restTemplate.getForObject("http://RATING-SERICE:8082/getRatings/"+usr.getId(),ArrayList.class);
                usr.setRatings(ratingsList);
            });
        }

        return usrLst;
    }

    @Override
    public void deleteUserById(String id) {
        usersRepository.deleteById(id);
    }

    @Override
    public Users updateUser(Users user) {
        return usersRepository.save(user);
    }
}
