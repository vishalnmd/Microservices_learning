package com.mslearning.user.service.services.Impl;

import com.mslearning.user.service.entities.Users;
import com.mslearning.user.service.exceptions.ResourceNotFoundException;
import com.mslearning.user.service.repositories.UsersRepository;
import com.mslearning.user.service.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users createUser(Users user) {
        UUID uuid = UUID.randomUUID();
        user.setId(uuid.toString());
        return usersRepository.save(user);
    }

    @Override
    public Users getUserById(String id) {
        return usersRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found"));
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
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
