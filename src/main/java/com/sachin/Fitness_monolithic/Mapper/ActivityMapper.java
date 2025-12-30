package com.sachin.Fitness_monolithic.Mapper;


import com.sachin.Fitness_monolithic.Dto.ActivityDto;
import com.sachin.Fitness_monolithic.Model.Activity;

public class ActivityMapper {


    //response
    public static ActivityDto toDto(Activity activity){
        return ActivityDto.builder()
                .Id(activity.getId())
                .createdAt(activity.getCreatedAt())
                .updatedAt(activity.getUpdatedAt())
                .userId(activity.getUser().getId())
                .type(activity.getType())
                .additionalMetrics(activity.getAdditionalMetrics())
                .duration(activity.getDuration())
                .recommendations(activity.getRecommendations())
                .startTime(activity.getStartTime())
                .caloriesBurned(activity.getCaloriesBurned())
                .build();
    }


    //request
//    public static Activity toActivity(ActivityDto activityDto){
//
//        return Activity.builder()
//               // .Id(activityDto.getId())            Auto generated Field
//               // .createdAt(activityDto.getCreatedAt())
//               // .updatedAt(activityDto.getUpdatedAt())
//              //  .user(user)
//                .type(activityDto.getType())
//                .additionalMetrics(activityDto.getAdditionalMetrics())
//                .duration(activityDto.getDuration())
//            //    .recommendations(activityDto.getRecommendations())
//                .startTime(activityDto.getStartTime())
//                .caloriesBurned(activityDto.getCaloriesBurned())
//                .build();
//    }
}
