package com.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Model.Trainee;
import com.project.Service.TraineeService;

@RestController
@RequestMapping("/Trainee")
public class TraineeController {

	@Autowired
	TraineeService service;

	@PostMapping("/addTrainee")

	public ResponseEntity<Trainee> addTrainee(@Validated @RequestBody Trainee t)

	{
		Trainee tra = service.addTraineeDetails(t);
		return new ResponseEntity<Trainee>(tra, HttpStatus.OK);

	}

}

