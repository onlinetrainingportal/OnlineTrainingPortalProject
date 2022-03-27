package com.project.Controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Exception.ResourceNotFoundException;
import com.project.Model.Trainee;
import com.project.Service.TraineeService;

@RestController
@RequestMapping("/registration")
public class TraineeController {
    
	@Autowired
	TraineeService service;
	@PostMapping("/addTrainee")
	public ResponseEntity<String> addTrainee(@Validated @RequestBody Trainee t)
	{
	Trainee tr = service.addTrainee(t);
	return new ResponseEntity<String>("Trainee registered successfully", HttpStatus.OK);
	}
	
	
	@GetMapping("/UserLogin")
	public ResponseEntity<String>checkUser(@RequestBody Trainee tr)
	{
	String status=null;
	Trainee obj = service.login(tr.getName(),tr.getPassword());
	if(Objects.nonNull(obj))
	        {
	    status="Welcome to the portal";
	        }
	else
	{
	     throw new ResourceNotFoundException("Invalid Credentials");
	}
	return new ResponseEntity<String>(status, HttpStatus.OK);
	}
	}
