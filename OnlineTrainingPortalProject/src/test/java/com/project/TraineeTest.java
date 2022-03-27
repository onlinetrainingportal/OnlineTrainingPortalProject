package com.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.project.Model.Trainee;
import com.project.Repository.TraineeRepository;
import com.project.Service.TraineeService;

@SpringBootTest
public class TraineeTest {
    @MockBean
    private TraineeRepository repo;
    @Autowired
    private TraineeService service;
    @Test
    public void saveTrainee() {
        Trainee trainee = new Trainee("sai","java","hyd","9065437288","aws",2020,"btech","sgoud","123");
        when(repo.save(trainee)).thenReturn(trainee);
        assertEquals(trainee, service.addTrainee(trainee));
    }
    @Test
    public void getNameAndPassword()
    {
        String userName="Sravani";
        String password="126780d51";
        Trainee trainee = new Trainee("kavya","c","mumbai","95467329005","cloud",2021,"barch","sedigi,", "456");
        when(repo.findByNameAndPassword(userName,password)).thenReturn(trainee);
        assertEquals(trainee,service.login(userName, password));
    }
    }