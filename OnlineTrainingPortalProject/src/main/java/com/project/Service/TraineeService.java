package com.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Model.Trainee;
import com.project.Repository.TraineeRepository;

@Service
public class TraineeService {
    @Autowired
    TraineeRepository repo;
    public Trainee  addTrainee(Trainee t)
    {
        Trainee tr =  repo.save(t);
        return tr;
    }
    public Trainee login(String name,String password)
    {
        Trainee obj=repo.findByNameAndPassword(name,password);
        return obj;
    }
}

