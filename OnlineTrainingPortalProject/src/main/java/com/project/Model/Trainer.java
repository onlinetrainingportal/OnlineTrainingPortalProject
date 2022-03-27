package com.project.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "TRAINER")
public class Trainer {
    @Id
    @Column(name = "TRAINERID")
    private String trainerId;
    @Column(name = "TRAINERNAME")
    @NotNull(message = "name should not be empty")
    private String name;
    @Column(name = "TECHNOLOGY")
    @NotNull(message = "technology should not be empty")
    private String technology;
    @Column(name = "LOCATION")
    @NotNull(message = "location should not be empty")
    private String location;
    @Column(name = "CONTACT")
    @NotNull(message = "contact should not be empty")
    @Size(max = 10)
    private String contact;
    @Column(name = "EMAIL")
    @NotNull(message = "email should not be empty")
    @Email(message = "email should be in valid format")
    private String email;
    @Column(name = "USERNAME")
    @NotNull(message = "username should not be empty")
    @Pattern(regexp = "[a-zA-Z0-9]+", message = "username should not contain special characters")
    private String userName;
    @Column(name = "PASSWORD")
    @NotNull(message = "password should not be empty")
    @Size(min = 8, message = "password must have atleast 8 characters")
    private String password;
    
    
    @OneToMany(mappedBy="trainer",  cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Trainee> trainee;
    
    
    public Trainer()
    {
    	super();
    }
    public Trainer(String name, String technology, String location, String contact, String email, String userName,
            String password) 
    {
        this.name = name;
        this.technology = technology;
        this.location = location;
        this.contact = contact;
        this.email = email;
        this.userName = userName;
    this.password = password;
}
    public String getTrainerId() {
        return trainerId;
    }
    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
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
    public String getUserName() {
        return userName;
    }
    public void setUsername(String userName) {
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
        return "Trainer [trainerId=" + trainerId + ", name=" + name + ", technology=" + technology + ", location="
                + location + ", contact=" + contact + ", email=" + email + "]";
    }
}
