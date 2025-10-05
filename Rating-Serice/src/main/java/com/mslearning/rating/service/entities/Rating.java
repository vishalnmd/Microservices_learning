package com.mslearning.rating.service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String ratingId;
    private String hotelId;
    private String userId;
    private int rating;
    private String feedback;
}
