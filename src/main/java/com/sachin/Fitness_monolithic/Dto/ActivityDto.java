package com.sachin.Fitness_monolithic.Dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sachin.Fitness_monolithic.Model.ActivityType;
import com.sachin.Fitness_monolithic.Model.Recommendation;
import com.sachin.Fitness_monolithic.Model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDto {




    private Long Id;
    private String userId;
    private ActivityType type;
    private Map<String,Object> additionalMetrics;

    private Integer duration;
    private Integer caloriesBurned;
    private LocalDateTime startTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    private List<Recommendation> recommendations = new ArrayList<>();

}
