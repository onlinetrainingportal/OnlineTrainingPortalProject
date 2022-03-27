package com.project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Model.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer> {
	
	List<Exam> findResultByExamIdAndSubjectName(int examId, String subjectName);
	

}
