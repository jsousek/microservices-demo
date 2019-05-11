package com.microservicesdemo.jsousek.controllers;

import com.microservicesdemo.jsousek.models.UserModel;
import com.microservicesdemo.jsousek.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/")
public class UserRestController {
    private UserRepository userRepository;

    @Autowired
    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(value = "/register")
    public ResponseEntity registerNewUser(@RequestBody @Validated UserModel newUser){
        userRepository.save(newUser);
        return ResponseEntity.ok("User registered successfully");

    }


}
