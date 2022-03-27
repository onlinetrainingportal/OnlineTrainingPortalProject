package com.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Model.Trainee;
import com.project.Repository.TraineeRepository;

@Service
public class TraineeService {
	
	@Autowired
	TraineeRepository repo;
	
	public Trainee addTraineeDetails(Trainee t) {
		  return repo.save(t);
	}
}

