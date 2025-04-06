package com.mslearning.user.service.services;

import com.mslearning.user.service.entities.Users;

import java.util.List;

public interface UsersService {

    Users createUser(Users user);

    Users getUserById(String id);

    List<Users> getAllUsers();

    void deleteUserById(String id);

    Users updateUser(Users user);
}
