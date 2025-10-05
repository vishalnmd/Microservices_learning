package com.mslearning.user.service.controller;

import com.mslearning.user.service.entities.Users;
import com.mslearning.user.service.services.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class UsersController {

    Logger logger = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    UsersService usersService;

    @PostMapping("/addUser")
    public ResponseEntity<String> createUsers(@RequestBody Users user){
        Users usr = usersService.createUser(user);
        if(usr != null){
            return ResponseEntity.ok("User created successfully");
        }else{
            return ResponseEntity.badRequest().body("User creation failed");
        }
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<Iterable<Users>> getAllUsers(){
        return ResponseEntity.ok(usersService.getAllUsers());
    }

    @GetMapping("/getUser/{userId}")
    public ResponseEntity<Users> getUserById(@PathVariable("userId") String userId){
        logger.info("Getting user with id: {}", userId);
        return ResponseEntity.ok(usersService.getUserById(userId));
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable("userId") String userId){
        usersService.deleteUserById(userId);
        return ResponseEntity.ok("User deleted successfully");
    }

    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUser(@RequestBody Users user){
        Users usr = usersService.updateUser(user);
        if(usr!=null)
            return ResponseEntity.ok("User updated successfully");
        else
            return ResponseEntity.badRequest().body("User update failed");
    }
}
