package me.mohammedriazkhan.controller.visit;

import me.mohammedriazkhan.domain.visit.Medication;
import me.mohammedriazkhan.factory.visit.MedicationFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MedicationControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/medication";

    @Test
    public void create() {

        Medication medication = MedicationFactory.getMedication("Ponado", "For Pain", 2);

        ResponseEntity<Medication> postResponse = restTemplate.postForEntity(baseURL + "/new", medication, Medication.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void findById() {

        Medication medication = restTemplate.getForObject(baseURL + "/find/1", Medication.class);

        assertNotNull(medication);

    }

    @Test
    public void update() {

        int id = 1;
        Medication medication = restTemplate.getForObject(baseURL + "/find/" + id, Medication.class);
        medication.setDose(5);

        restTemplate.put(baseURL + "/update/" + id, medication);

        Medication updatedDoctor = restTemplate.getForObject(baseURL + "/update/" + id, Medication.class);

        assertNotNull(updatedDoctor);

    }

    @Test
    public void delete() {

        int id = 1;
        Medication medication = restTemplate.getForObject(baseURL + "/find/" + id, Medication.class);
        assertNotNull(medication);

        restTemplate.delete(baseURL + "/delete/" + id);

        try {
            medication = restTemplate.getForObject(baseURL + "/find/" + id, Medication.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }

    }

    @Test
    public void getAll() {

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());

    }
}