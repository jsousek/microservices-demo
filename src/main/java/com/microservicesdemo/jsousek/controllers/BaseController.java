package com.microservicesdemo.jsousek.controllers;

import com.microservicesdemo.jsousek.models.UserModel;
import com.microservicesdemo.jsousek.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.NoSuchElementException;

public class BaseController {

    UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserModel getUserFromSecurityContext(){
        return userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow(NoSuchElementException::new);
    }
}
