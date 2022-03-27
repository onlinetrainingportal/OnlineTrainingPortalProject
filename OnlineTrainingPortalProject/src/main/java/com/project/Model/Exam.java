package com.project.Model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "EXAM")
public class Exam {

	@Id
	@Column(name = "EXAMID")
	private int examId;

	@Column(name = "DATEOFEXAM")
	@NotNull(message = "Date cannot be empty")
	private Date dateOfExam;
	
	@Column(name = "SCORE")
	private int score;

	
	@Column(name = "SUBJECTNAME")
	@NotEmpty
	@Size(max=10, message = "subject name should not be more than 10 characters")
	private String subjectName;

	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "TRAINEEID")
	@JsonBackReference
	private Trainee trainee;
	
	
	public Exam() {
		
		super();
	}
	
	public Exam(int examId, int score, String subjectName) {
		super();
		this.examId = examId;
		this.score = score;
		this.subjectName = subjectName;
		
	}
	
	

	public Exam( int score, String subjectName,Trainee trainee ) {
		super();
	
		this.score = score;
		this.subjectName = subjectName;
		this.trainee = trainee;
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public Date getDateOfExam() {
		return dateOfExam;
	}

	public void setDateOfExam(Date dateOfExam) {
		this.dateOfExam = dateOfExam;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", dateOfExam=" + dateOfExam + ", score=" + score + ", subjectName="
				+ subjectName + "]";
	}

	public String getName() {
		return trainee.getName();
	}

	public String getTechnology() {
		return trainee.getTechnology();
	}

}
