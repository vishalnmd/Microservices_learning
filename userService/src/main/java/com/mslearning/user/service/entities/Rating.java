package com.mslearning.user.service.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

    private String rattingId;
    private String userId;
    private String hotelId;
    private int ratting;
    private String feedback;
    private Hotel hotel;
}
