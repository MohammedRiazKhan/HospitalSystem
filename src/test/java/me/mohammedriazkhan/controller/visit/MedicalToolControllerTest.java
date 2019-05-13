package me.mohammedriazkhan.controller.visit;

import me.mohammedriazkhan.domain.visit.MedicalTool;
import me.mohammedriazkhan.factory.visit.MedicationFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MedicalToolControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/medicaltool";

    @Test
    public void create() {


    }

    @Test
    public void findById() {



    }

    @Test
    public void update() {



    }

    @Test
    public void delete() {



    }

    @Test
    public void getAll() {



    }
}