package com.sachin.Fitness_monolithic.Repository;

import com.sachin.Fitness_monolithic.Model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation,Long> {

    List<Recommendation> findByUserId(String userId);

    List<Recommendation> findByActivityId(Long activityId);
}
