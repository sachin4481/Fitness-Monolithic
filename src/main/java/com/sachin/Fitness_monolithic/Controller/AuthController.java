package com.sachin.Fitness_monolithic.Controller;


import com.sachin.Fitness_monolithic.Dto.UserDto;
import com.sachin.Fitness_monolithic.Mapper.UserMapper;
import com.sachin.Fitness_monolithic.Model.User;
import com.sachin.Fitness_monolithic.Repository.UserRepository;
import com.sachin.Fitness_monolithic.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        User user= UserMapper.toUser(userDto);
        User userResponseEntity = userService.savedUser(user);
        return new ResponseEntity<>( UserMapper.toDto(userResponseEntity), HttpStatus.CREATED);



    }

    //Remove User

    @DeleteMapping("/{Id}")
    public ResponseEntity<String> RemoveUser(@PathVariable String Id){
        userRepository.deleteById(Id);
        return new ResponseEntity<>("Removed",HttpStatus.OK);
    }

}
