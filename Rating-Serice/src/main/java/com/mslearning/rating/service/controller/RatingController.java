package com.mslearning.rating.service.controller;

import com.mslearning.rating.service.entities.Rating;
import com.mslearning.rating.service.services.RatingService;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.List;

@RestController
public class RatingController {
    @Autowired
    RatingService service;
    Logger logger = LoggerFactory.getLogger(RatingController.class);

    @PostMapping("/addRating")
    public ResponseEntity<String> addRatting(@RequestBody Rating rating){
        Rating ratingResponse = service.addRatting(rating);
        if(ratingResponse == null){
            return ResponseEntity.ok("something went wrong");
        }else{
            return ResponseEntity.ok("Rating successfully submitted, thanks for your feedback");
        }
    }

    @GetMapping("/getAllRatings")
    public ResponseEntity<List<Rating>> getAllRatings(){
        List<Rating> ratingLst = service.getAllRatings();
        return ResponseEntity.ok(ratingLst);
    }

    @GetMapping("/getRatings/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingByUserId(@PathVariable("userId") String userId){
        List<Rating> ratingLst = service.getRattingById(userId);

        return ResponseEntity.ok(ratingLst);
    }

    /*@PutMapping("/updateRating/{userId}")
    public ResponseEntity<String> updateUserRating(@PathVariable("userId")String userId,Rating rating){

    }*/

}