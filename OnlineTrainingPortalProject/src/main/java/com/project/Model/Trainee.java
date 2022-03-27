package com.project.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "TRAINEE")
public class Trainee {
	
	@Id
	@Column(name = "TRAINEEID")
	private String traineeId;
	
	@Column(name = "TRAINEENAME")
	private String name;
	
	@Column(name = "TECHNOLOGY")
	private String technology;
	
	@Column(name = "LOCATION")
	private String location;
	
	@Column(name = "CONTACT")
	private String contact;
	
	@Column(name = "DOMAIN")
	private String domain;
	
	@Column(name = "PASSOUTYEAR")
	private int passoutYear;
	
	@Column(name = "EDUCATION")
	private String education;

	@ManyToOne
	@JoinColumn(name="TRAINERID")
	@JsonBackReference
	private Trainer trainer;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "trainee")
	@JsonManagedReference
	private Exam exam;
	
	public Trainee() {
		super();
	}
	
	public Trainee(String traineeId, String name, String technology, String location, String contact,
			String domain, int passoutYear, String education) {
		super();
		this.traineeId = traineeId;
		this.name = name;
		this.technology = technology;
		this.location = location;
		this.contact = contact;
		this.domain = domain;
		this.passoutYear = passoutYear;
		this.education = education;
	}

    public String getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(String traineeId) {
		this.traineeId = traineeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public int getPassoutYear() {
		return passoutYear;
	}

	public void setPassoutYear(int passoutYear) {
		this.passoutYear = passoutYear;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	
	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", name=" + name + ", technology=" + technology + ", location="
				+ location + ", contact=" + contact + ", domain=" + domain + ", passoutYear=" + passoutYear
				+ ", education=" + education + "]";
	}
	
}

