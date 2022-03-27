package com.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Model.Trainer;
import com.project.Service.TrainerService;

@RestController
@RequestMapping("/Trainer")
public class TrainerController {
	
	@Autowired
	TrainerService service;
	

	@PostMapping("/addTrainer")
	  public ResponseEntity<Trainer> addTrainer(@RequestBody Trainer tn) 
      { 
		Trainer trn = service.addTrainerDetails(tn); 
		return new ResponseEntity<Trainer>(trn,HttpStatus.OK);
	  }
}

