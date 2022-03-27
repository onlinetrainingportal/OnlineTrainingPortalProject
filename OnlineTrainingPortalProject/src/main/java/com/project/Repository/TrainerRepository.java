package com.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Model.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, String> {
    Trainer findByNameAndPassword(String UserName, String password);
}