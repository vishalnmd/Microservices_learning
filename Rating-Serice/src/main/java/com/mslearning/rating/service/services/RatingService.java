package com.mslearning.rating.service.services;

import com.mslearning.rating.service.entities.Rating;

import java.util.List;

public interface RatingService {

    Rating addRatting(Rating rating);
    List<Rating> getRattingById(String id);
    List<Rating> getAllRatings();
    Rating updateRatting(Rating rating);
    void deleteRattingById(String id);
}
