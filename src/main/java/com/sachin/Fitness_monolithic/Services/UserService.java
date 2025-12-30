package com.sachin.Fitness_monolithic.Services;

import com.sachin.Fitness_monolithic.Model.User;
import com.sachin.Fitness_monolithic.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //save user
    public User savedUser(User user){
        return userRepository.save(user);
    }
}
