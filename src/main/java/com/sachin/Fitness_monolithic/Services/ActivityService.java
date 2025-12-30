package com.sachin.Fitness_monolithic.Services;

import com.sachin.Fitness_monolithic.Dto.ActivityDto;
import com.sachin.Fitness_monolithic.Mapper.ActivityMapper;
import com.sachin.Fitness_monolithic.Model.Activity;
import com.sachin.Fitness_monolithic.Model.User;
import com.sachin.Fitness_monolithic.Repository.ActivityRepository;
import com.sachin.Fitness_monolithic.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;

    //saved activity
    public ActivityDto savedActivity(ActivityDto activityDto){

        User user = userRepository.findById(activityDto.getUserId()).orElseThrow(()->
                new EntityNotFoundException("User not found"));


        Activity activity = Activity.builder()
                .user(user)
                .type(activityDto.getType())
                .duration(activityDto.getDuration())
                .startTime(activityDto.getStartTime())
                .caloriesBurned(activityDto.getCaloriesBurned())
                .additionalMetrics(activityDto.getAdditionalMetrics())
                .build();
        Activity savedActivity = activityRepository.save(activity);
        return ActivityMapper.toDto(savedActivity);

    }

    //fetch activity
    public Activity getActivityById(Long id){
        return activityRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Not found Activity for this Id"));
    }

    //fetch activity for specific user
    public List<ActivityDto> getActivityForUser(String id){
        List<Activity> activity = activityRepository.findByUserId(id);
       return  activity.stream()
               .map(activity1 -> ActivityMapper.toDto(activity1)).toList();
    }

}
