package com.project.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "TRAINEE")
public class Trainee {
@Id
@Column(name="TRAINEEID")
private String traineeId;
@Column(name="TRAINEENAME")
@NotNull(message="name should not be empty")
private String name;
@Column(name="TECHNOLOGY")
@NotNull(message="technology should not be empty")
private String technology;
@Column(name="LOCATION")
@NotNull(message="location should not be empty")
private String location;
@Column(name="CONTACT")
@NotNull(message="technology should not be empty")
@Size(min=1,max=10)
private String contact;
@Column(name="DOMAIN")
@NotNull(message="domain should not be empty")
private String domain;
@Column(name="PASSOUTYEAR")
@NotNull(message="passoutyear should not be empty")
private int passoutYear;
@Column(name="EDUCATION")
@NotNull(message="education should not be empty")
private String education;
@Column(name="USERNAME")
@NotNull(message="username should not be empty")
@Pattern(regexp="[a-zA-Z0-9]+", message="username should not contain special character")
private String userName;
@Column(name="PASSWORD")
@NotNull(message="password should not be empty")
@Size(min = 8,message="password  must have atleast 8 characters")
private String password;

@ManyToOne
@JoinColumn(name="TRAINERID")
@JsonBackReference
private Trainer trainer;

@OneToOne(cascade = CascadeType.ALL,mappedBy = "trainee")
@JsonManagedReference
private Exam exam;


public Trainee()
{
	super();
}

 public Trainee(String name,String technology, String location,String contact,String domain, int passoutYear,String education,String userName,String password)
{
    this.name = name;
    this.technology = technology;
    this.location = location;
    this.contact = contact;
    this.domain = domain;
    this.passoutYear = passoutYear;
    this.education = education;
    this.userName = userName;
    this.password = password;
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
public String getUserName() {
    return userName;
}
public void setUserName(String userName) {
    this.userName = userName;
}
public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}
@Override
public String toString() {
    return "Trainee [traineeId=" + traineeId + ", name=" + name + ", technology=" + technology
            + ", location=" + location + ", contact=" + contact + ", domain=" + domain + ", passoutYear=" + passoutYear
            + ", education=" + education + "]";
}
}
