package com.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Model.Trainer;
import com.project.Repository.TrainerRepository;

@Service
public class TrainerService {
    @Autowired
    TrainerRepository repo;
    public Trainer addTrainer(Trainer t) {
         return repo.save(t);
    }
    public Trainer login(String UserName, String password) {
        Trainer obj = repo.findByNameAndPassword(UserName, password);
        return obj;
    }
}
