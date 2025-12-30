package com.sachin.Fitness_monolithic.Mapper;

import com.sachin.Fitness_monolithic.Dto.UserDto;
import com.sachin.Fitness_monolithic.Model.User;

public class UserMapper {

    //response
    public static UserDto toDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .role(user.getRole())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .build();
    }


    //request
    public static User toUser(UserDto userDto){
        return User.builder()

                .email(userDto.getEmail())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .password(userDto.getPassword())
                .build();
    }
}
