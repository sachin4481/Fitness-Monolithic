package com.sachin.Fitness_monolithic.Dto;
import com.sachin.Fitness_monolithic.Model.role;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private role role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
