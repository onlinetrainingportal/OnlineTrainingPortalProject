package com.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.project.Model.Exam;
import com.project.Model.Trainee;
import com.project.Repository.ExamRepository;
import com.project.Service.ExamService;

@SpringBootTest
public class ExamTest {

	@MockBean
	private ExamRepository repository;
	
	@Autowired
	private ExamService service;
	
	
	
	@Test
	public void saveOnlyExamDetails()
	{
		Exam exam = new Exam(96,"C++",null);
		when(repository.save(exam)).thenReturn(exam);
		assertEquals(exam, service.addExamDetails(exam));
	}
	
	
	@Test
	public void saveExamDetails()
	{
		Trainee trainee = new Trainee("TNE-JAV-4","John","Java","Kolkata","9875632452","AWS",2019,"Btech");
		Exam exam = new Exam(96,"Core Java",trainee);
		when(repository.save(exam)).thenReturn(exam);
		assertEquals(exam, service.addExamDetails(exam));
	}
	
	
	
	@Test
	public void generateResult()
	{
		int examId =100;
		String subjectName="CORE JAVA";
		when(repository.findResultByExamIdAndSubjectName(examId, subjectName))
		.thenReturn(Stream.of(new Exam(100,87,"JAVA" )).collect(Collectors.toList()));
		
		assertEquals(1, service.findResultByExamIdAndSubjectName(examId, subjectName).size());
	}
	
	
}

