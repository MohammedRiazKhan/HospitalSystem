package me.mohammedriazkhan.controller.patient;

import me.mohammedriazkhan.domain.patient.OutPatient;
import me.mohammedriazkhan.domain.patient.Patient;
import me.mohammedriazkhan.factory.patient.InPatientFactory;
import me.mohammedriazkhan.factory.patient.OutPatientFactory;
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

import java.util.UUID;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OutPatientControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/patient/inpatient";

    @Test
    public void a_create() {

        OutPatient inPatient = OutPatientFactory.getOutPatient("MOhammed", "Khan", null, null, 23, null, null);
        inPatient.setPatientId("fasd");
        ResponseEntity<OutPatient> postResponse = restTemplate.postForEntity(baseURL + "/new", inPatient, OutPatient.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void c_findById() {

        OutPatient inPatient = restTemplate.getForObject(baseURL + "/find/avc", OutPatient.class);

        assertNotNull(inPatient);

    }

    @Test
    public void d_update() {

        int id = 1;
        OutPatient inPatient = restTemplate.getForObject(baseURL + "/find/" + "avc", OutPatient.class);
        inPatient.setFirstName("riaz");

        restTemplate.put(baseURL + "/update/" + "avc", inPatient);

        OutPatient updatedDoctor = restTemplate.getForObject(baseURL + "/update/" + "avc", OutPatient.class);

        assertNotNull(updatedDoctor);

    }

    @Test
    public void e_delete() {

        int id = 1;
        OutPatient inPatient = restTemplate.getForObject(baseURL + "/find/" + "avc", OutPatient.class);
        assertNotNull(inPatient);

        restTemplate.delete(baseURL + "/delete/" + "avc");

        try {
            inPatient = restTemplate.getForObject(baseURL + "/find/" + "avc", OutPatient.class);
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
