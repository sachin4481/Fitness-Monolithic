package com.sachin.Fitness_monolithic.Controller;


import com.sachin.Fitness_monolithic.Model.User;
import com.sachin.Fitness_monolithic.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return userService.savedUser(user);
    }


}
