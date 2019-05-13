package me.mohammedriazkhan.controller.patient;

import me.mohammedriazkhan.domain.patient.Patient;
import me.mohammedriazkhan.factory.patient.InPatientFactory;
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
public class InPatientControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/patient/inpatient";

    @Test
    public void create() {

        Patient inPatient = InPatientFactory.getInPatient("MOhammed", "Khan", null, null, 23, null);

        ResponseEntity<Patient> postResponse = restTemplate.postForEntity(baseURL + "/new", inPatient, Patient.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void findById() {

        Patient inPatient = restTemplate.getForObject(baseURL + "/find/1", Patient.class);

        assertNotNull(inPatient);

    }

    @Test
    public void update() {

        int id = 1;
        Patient inPatient = restTemplate.getForObject(baseURL + "/find/" + id, Patient.class);
        inPatient.setFirstName("riaz");

        restTemplate.put(baseURL + "/update/" + id, inPatient);

        Patient updatedDoctor = restTemplate.getForObject(baseURL + "/update/" + id, Patient.class);

        assertNotNull(updatedDoctor);

    }

    @Test
    public void delete() {

        int id = 1;
        Patient inPatient = restTemplate.getForObject(baseURL + "/find/" + id, Patient.class);
        assertNotNull(inPatient);

        restTemplate.delete(baseURL + "/delete/" + id);

        try {
            inPatient = restTemplate.getForObject(baseURL + "/find/" + id, Patient.class);
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