package com.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Exception.ResourceNotFoundException;
import com.project.Model.Exam;
import com.project.Service.ExamService;

@RestController
@RequestMapping("/Result")
public class ExamController {

	@Autowired
	ExamService service;
	
	
	
	@PostMapping("/addExamDetails")
	   public ResponseEntity<Exam> addExam(@Validated @RequestBody Exam e)
    { 
		Exam ex = service.addExamDetails(e); 
		return new ResponseEntity<Exam>(ex,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/fetchResult")
	public ResponseEntity<List<Exam>> generateResult(@RequestParam int examId,@RequestParam String subjectName) {
        
		List<Exam> obj = service.findResultByExamIdAndSubjectName(examId, subjectName);
		
		if(!obj.isEmpty())
		{
			
			return new ResponseEntity<List<Exam>>(obj, HttpStatus.OK);
			
		}
		else
		{
			throw new ResourceNotFoundException("Result not generated successfully");
		}
		

	}

}

