package com.microservicesdemo.jsousek.error_response;

import com.microservicesdemo.jsousek.controllers.UserRestController;
import com.microservicesdemo.jsousek.models.UserModel;
import com.microservicesdemo.jsousek.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ErrorResponseService {
    private UserRepository userRepository;

    public ErrorResponseService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean usernameTaken(UserModel userModel){
        return userRepository.findByUsername(userModel.username).isPresent();

    }
}
