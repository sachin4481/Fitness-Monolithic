package com.sachin.Fitness_monolithic.Controller;

import com.sachin.Fitness_monolithic.Dto.ActivityDto;
import com.sachin.Fitness_monolithic.Mapper.ActivityMapper;
import com.sachin.Fitness_monolithic.Model.Activity;
import com.sachin.Fitness_monolithic.Services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;



    //track activities
    @PostMapping
    public ResponseEntity<ActivityDto> addActivity(@RequestBody ActivityDto activityDto){
       return new ResponseEntity<>(activityService.savedActivity(activityDto),HttpStatus.CREATED);
    }

    //Retrieve Activity
    @GetMapping("/{id}")
    public ResponseEntity<ActivityDto> retrieveActivity(@PathVariable Long id){
       Activity activity =  activityService.getActivityById(id);
       return new ResponseEntity<>(ActivityMapper.toDto(activity),HttpStatus.OK);
    }


    //Retrieve Activity For user
    @GetMapping("user")
    public ResponseEntity<List<ActivityDto>> activityUser(
            @RequestHeader(value = "X-User-Id") String id){
        return new ResponseEntity<>(activityService.getActivityForUser(id),HttpStatus.OK);
    }

}
