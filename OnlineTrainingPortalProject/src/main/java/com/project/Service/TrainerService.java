package com.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Model.Trainer;
import com.project.Repository.TrainerRepository;

@Service
public class TrainerService {
	@Autowired
	TrainerRepository repo;
	
	public Trainer addTrainerDetails(Trainer tn) {
		return repo.save(tn);
		 }
}

