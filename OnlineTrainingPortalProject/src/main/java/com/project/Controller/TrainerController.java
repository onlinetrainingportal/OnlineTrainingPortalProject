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
import com.project.Model.Trainer;
import com.project.Service.TrainerService;

@RestController
@RequestMapping("/registrationPage")
public class TrainerController {
    @Autowired
    TrainerService service;
    @PostMapping("/addTrainer")
    public ResponseEntity<String> addTrainer(@Validated @RequestBody Trainer t) {
        Trainer tr = service.addTrainer(t);
        return new ResponseEntity<String>("Trainer registered successfully", HttpStatus.OK);
    }
    
    @GetMapping("/UserLogin")
    public ResponseEntity<String> checkUser(@RequestBody Trainer tr) {
        String status = null;
        Trainer obj = service.login(tr.getUserName(), tr.getPassword());
        if (Objects.nonNull(obj)) {
            status = "Welcome to the portal";
        } else 
        {
            throw new ResourceNotFoundException("Invalid Credentials");
        }
        return new ResponseEntity<String>(status, HttpStatus.OK);
    }
}

