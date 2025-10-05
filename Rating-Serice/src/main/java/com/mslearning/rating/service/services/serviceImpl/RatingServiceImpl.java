package com.mslearning.rating.service.services.serviceImpl;

import com.mslearning.rating.service.Repositories.RatingRepository;
import com.mslearning.rating.service.entities.Rating;
import com.mslearning.rating.service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository repo;

    @Override
    public Rating addRatting(Rating rating) {
        return repo.save(rating);
    }

    @Override
    public List<Rating> getRattingById(String id) {
        return repo.findByUserId(id);
    }

    @Override
    public List<Rating> getAllRatings() {
        return repo.findAll();
    }

    @Override
    public Rating updateRatting(Rating rating) {
        return repo.save(rating);
    }

    @Override
    public void deleteRattingById(String id) {
        repo.deleteById(id);
    }
}
