package me.mohammedriazkhan.controller.hospital;

import me.mohammedriazkhan.domain.hospital.Hospital;
import me.mohammedriazkhan.factory.hospital.HospitalFactory;
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
public class HospitalControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/hospital";

    @Test
    public void create() {

        Hospital hospital = HospitalFactory.getHospital(null, 1, "Greys Memorial");

        ResponseEntity<Hospital> postResponse = restTemplate.postForEntity(baseURL + "/new", hospital, Hospital.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void findById() {

        Hospital hospital = restTemplate.getForObject(baseURL + "/find/1", Hospital.class);

        assertNotNull(hospital);

    }

    @Test
    public void update() {

        int id = 1;
        Hospital hospital  = restTemplate.getForObject(baseURL + "/find/" + id, Hospital.class);


        restTemplate.put(baseURL + "/update/" + id, hospital);

        Hospital updatedDoctor = restTemplate.getForObject(baseURL + "/update/" + id, Hospital.class);

        assertNotNull(updatedDoctor);

    }

    @Test
    public void delete() {

        int id = 1;
        Hospital hospital = restTemplate.getForObject(baseURL + "/find/" + id, Hospital.class);
        assertNotNull(hospital);

        restTemplate.delete(baseURL + "/delete/" + id);

        try {
            hospital = restTemplate.getForObject(baseURL + "/find/" + id, Hospital.class);
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