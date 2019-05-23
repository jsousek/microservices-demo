package com.microservicesdemo.jsousek.services;

import com.microservicesdemo.jsousek.models.ResponseModel;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {
    public ResponseModel succesfulRegistrationResponse(String username){
        return ResponseModel.builder()
                .user(username)
                .message("new user created with username: "+username)
                .build();
    }
}
