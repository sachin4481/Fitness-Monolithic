package com.sachin.Fitness_monolithic.Services;

import com.sachin.Fitness_monolithic.Dto.RecommendationDto;
import com.sachin.Fitness_monolithic.Model.Activity;
import com.sachin.Fitness_monolithic.Model.Recommendation;
import com.sachin.Fitness_monolithic.Model.User;
import com.sachin.Fitness_monolithic.Repository.ActivityRepository;
import com.sachin.Fitness_monolithic.Repository.RecommendationRepository;
import com.sachin.Fitness_monolithic.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;
    private final RecommendationRepository recommendationRepository;

    //Generate Recommendation
    public Recommendation generateRecommendation(RecommendationDto recommendationDto) {
        User user = userRepository.findById(recommendationDto.getUserId()).orElseThrow(
                ()->new EntityNotFoundException("User not found for this Id")
        );

        Activity activity = activityRepository.findById(recommendationDto.getActivityId()).orElseThrow(() ->
                new EntityNotFoundException("Activity Not found for this Id"));

        Recommendation recommendation = Recommendation.builder()
                .activity(activity)
                .user(user)
                .improvements(recommendationDto.getImprovements())
                .safety(recommendationDto.getSafety())
                .suggestions(recommendationDto.getSuggestions())
                .build();

        return recommendationRepository.save(recommendation);
    }

    //get Recommendation for user
    public List<Recommendation> getUserRecommendation(String UserId){
        List<Recommendation> byUserId = recommendationRepository.findByUserId(UserId);
        if (byUserId.isEmpty()) {
            throw new EntityNotFoundException(
                    "No recommendations found for userId: " + UserId
            );
        }
        return byUserId;
    };

    //get Recommendation for Activity
    public List<Recommendation> getActivityRecommendation(Long activityId){
        List<Recommendation> byActivityId = recommendationRepository.findByActivityId(activityId);
        if (byActivityId.isEmpty()) {
            throw new EntityNotFoundException(
                    "No recommendations found for userId: " + activityId
            );
        }
        return byActivityId;
    };


}
