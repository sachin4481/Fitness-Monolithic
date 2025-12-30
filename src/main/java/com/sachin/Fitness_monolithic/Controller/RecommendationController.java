package com.sachin.Fitness_monolithic.Controller;

import com.sachin.Fitness_monolithic.Dto.ActivityDto;
import com.sachin.Fitness_monolithic.Dto.RecommendationDto;
import com.sachin.Fitness_monolithic.Model.Recommendation;
import com.sachin.Fitness_monolithic.Services.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/recommendation")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @PostMapping("/generate")
    public ResponseEntity<Recommendation> generateRecommendation(
            @RequestBody RecommendationDto recommendationDto
    ){
        Recommendation recommendation = recommendationService.generateRecommendation(recommendationDto);
        return ResponseEntity.ok(recommendation);
    }

    //Get User Recommendation
    @GetMapping("user")
    public ResponseEntity<List<Recommendation>> getUserRecommendation(
            @RequestHeader(value = "X-User-Id") String id){
        return new ResponseEntity<>(recommendationService.getUserRecommendation(id), HttpStatus.OK);
    }


    //Get Activity Recommendation
    @GetMapping("activity")
    public ResponseEntity<List<Recommendation>> getUserRecommendation(
            @RequestHeader(value = "X-Activity-Id") Long id){
        return new ResponseEntity<>(recommendationService.getActivityRecommendation(id), HttpStatus.OK);
    }



}
