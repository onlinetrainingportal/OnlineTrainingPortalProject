package com.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Model.Trainee;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee, String>{
     Trainee findByNameAndPassword(String name,String password);
}
