package com.mslearning.user.service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Users {

    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String about;

    @Transient
    private List<Rating> ratings;
}
