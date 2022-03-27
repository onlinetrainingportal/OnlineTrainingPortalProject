package com.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.project.Model.Trainer;
import com.project.Repository.TrainerRepository;
import com.project.Service.TrainerService;

@SpringBootTest
public class TrainerTest {
    @MockBean
    private TrainerRepository repo;
    @Autowired
    private TrainerService service;
    @Test
    public void saveTrainer() {
        Trainer trainer = new Trainer("Div", "MDH", "8945634578", "Luck@gmail.com", "MSU", "YyY","uyt");
        when(repo.save(trainer)).thenReturn(trainer);
        assertEquals(trainer, service.addTrainer(trainer));
    }
    @Test
    public void getNameAndPassword()
    {
        String userName="laxmi";
        String password="123Kkkk";
        Trainer trainer = new Trainer("oo","ll","8909897890","lli@gmail.com","ppp","ooo","bhy");
        when(repo.findByNameAndPassword(userName,password)).thenReturn(trainer);
        assertEquals(trainer,service.login(userName, password));
    }
     
}
