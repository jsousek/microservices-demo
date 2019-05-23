package com.microservicesdemo.jsousek.controllers;

import com.microservicesdemo.jsousek.error_response.ErrorResponseService;
import com.microservicesdemo.jsousek.models.UserModel;
import com.microservicesdemo.jsousek.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/")
public class UserRestController extends BaseController{
    private UserRepository userRepository;
    private ErrorResponseService errorResponse;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserRestController(UserRepository userRepository, ErrorResponseService errorResponse) {
        this.userRepository = userRepository;
        this.errorResponse = errorResponse;
    }

    @GetMapping("/")
    public String hello(){
        return "Hello";
    }

    @PostMapping(value = "/register")
    public ResponseEntity registerNewUser(@RequestBody @Validated UserModel newUser){

        if(errorResponse.usernameTaken(newUser)){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse.usernameTakenResponse(newUser.getUsername()));
        }
        newUser.setHashedPassword(passwordEncoder.encode(newUser.hashedPassword));
        userRepository.save(newUser);
        return ResponseEntity.ok("User registered successfully");

    }




}
