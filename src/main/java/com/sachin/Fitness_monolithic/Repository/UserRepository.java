package com.sachin.Fitness_monolithic.Repository;

import com.sachin.Fitness_monolithic.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
}
