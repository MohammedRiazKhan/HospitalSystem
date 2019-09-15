package me.mohammedriazkhan.controller.patient;

import me.mohammedriazkhan.domain.patient.InPatient;
import me.mohammedriazkhan.domain.patient.Patient;
import me.mohammedriazkhan.factory.patient.InPatientFactory;
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
public class InPatientControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/patient/inpatient";

    @Test
    public void a_create() {

        InPatient inPatient = InPatientFactory.getInPatient("MOhammed", "Khan", null, null, 23, null);
        inPatient.setPatientId("avc");
        ResponseEntity<InPatient> postResponse = restTemplate.postForEntity(baseURL + "/new", inPatient, InPatient.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void b_findById() {

        InPatient inPatient = restTemplate.getForObject(baseURL + "/find/avc", InPatient.class);

        assertNotNull(inPatient);

    }

    @Test
    public void c_update() {

        int id = 1;
        InPatient inPatient = restTemplate.getForObject(baseURL + "/find/" + "avc", InPatient.class);
        inPatient.setFirstName("riaz");

        restTemplate.put(baseURL + "/update/" + "avc", inPatient);

        InPatient updatedDoctor = restTemplate.getForObject(baseURL + "/update/" + "avc", InPatient.class);

        assertNotNull(updatedDoctor);

    }

    @Test
    public void e_delete() {

        int id = 1;
        InPatient inPatient = restTemplate.getForObject(baseURL + "/find/" + "avc", InPatient.class);
        assertNotNull(inPatient);

        restTemplate.delete(baseURL + "/delete/" + "avc");

        try {
            inPatient = restTemplate.getForObject(baseURL + "/find/" + "avc", InPatient.class);
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