package com.mslearning.user.service.repositories;

import com.mslearning.user.service.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, String> {
}
