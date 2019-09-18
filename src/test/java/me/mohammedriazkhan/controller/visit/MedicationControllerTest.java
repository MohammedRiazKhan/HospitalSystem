package me.mohammedriazkhan.controller.visit;

import me.mohammedriazkhan.domain.visit.Medication;
import me.mohammedriazkhan.factory.visit.MedicationFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MedicationControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/medication";

    @Test
    public void a_create() {

        Medication medication = MedicationFactory.getMedication("Ponado", "For Pain", 2);
        medication.setMedicationId("abcc");
        ResponseEntity<Medication> postResponse = restTemplate.postForEntity(baseURL + "/new", medication, Medication.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void b_findById() {

        Medication medication = restTemplate.getForObject(baseURL + "/find/abcc", Medication.class);

        assertNull(medication);

    }

    @Test
    public void c_update() {

//        int id = 1;
//        Medication medication = restTemplate.getForObject(baseURL + "/find/" + "abcc", Medication.class);
//        medication.setQuantity(5);
//
//        restTemplate.put(baseURL + "/update/" + "abcc", medication);
//
//        Medication updatedDoctor = restTemplate.getForObject(baseURL + "/update/" + "abcc", Medication.class);
//
//        assertNotNull(updatedDoctor);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Medication medication = restTemplate.getForObject(baseURL + "/find/" + "abcc", Medication.class);
        assertNull(medication);

        restTemplate.delete(baseURL + "/delete/" + "abcc");

        try {
            medication = restTemplate.getForObject(baseURL + "/find/" + "abcc", Medication.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }

    }

    @Test
    public void d_getAll() {

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());

    }
}