package com.mslearning.rating.service.Repositories;

import com.mslearning.rating.service.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,String> {
    List<Rating> findByUserId(String id);
}
