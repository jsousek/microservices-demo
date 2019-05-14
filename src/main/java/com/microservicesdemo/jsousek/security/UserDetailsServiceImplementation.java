package com.microservicesdemo.jsousek.security;


import com.microservicesdemo.jsousek.models.UserModel;
import com.microservicesdemo.jsousek.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.NoSuchElementException;

public class UserDetailsServiceImplementation implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException(username));
        return new User(userModel.getUsername(), userModel.getHashedPassword(), Collections.emptyList());
    }
}
