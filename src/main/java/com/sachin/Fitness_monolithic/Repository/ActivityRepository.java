package com.sachin.Fitness_monolithic.Repository;

import com.sachin.Fitness_monolithic.Model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

   List<Activity> findByUserId(String id);
}
