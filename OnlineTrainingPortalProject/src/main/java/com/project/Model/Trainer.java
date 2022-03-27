package com.project.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "TRAINER")
public class Trainer {
	
	@Id
	@Column(name = "TRAINERID")
	private String trainerId;

	@Column(name = "TRAINERNAME")
	private String name;

	@Column(name = "TECHNOLOGY")
	private String technology;

	@Column(name = "LOCATION")
	private String location;
	
	
	@Column(name = "CONTACT")
	private String contact;

	@Column(name = "EMAIL")
	private String email;
	
	
	@OneToMany(mappedBy="trainer",  cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Trainee> trainee;

	

	public Trainer() {
		super();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}

	public List<Trainee> getTrainee() {
		return trainee;
	}

	public void setTrainee(List<Trainee> trainee) {
		this.trainee = trainee;
	}

	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainerId + ", name=" + name + ", technology=" + technology
				+ ", location=" + location + ", contact=" + contact + ", email=" + email + "]";
	}

	

}
