package com.sachin.Fitness_monolithic.Dto;

import com.sachin.Fitness_monolithic.Model.Activity;
import com.sachin.Fitness_monolithic.Model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommendationDto {

    private Long Id;

    private String userId;
    private Long activityId;

   // private String type;

   // private String recommendation;

    private List<String> improvements;
    private List<String> safety;
    private List<String> suggestions;
}
