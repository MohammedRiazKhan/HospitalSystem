package me.mohammedriazkhan.controller.hospital;

import me.mohammedriazkhan.domain.hospital.Ward;
import me.mohammedriazkhan.factory.hospital.WardFactory;
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
public class WardControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/department/ward";

    @Test
    public void create() {

        Ward ward = WardFactory.getWard("A");

        ResponseEntity<Ward> postResponse = restTemplate.postForEntity(baseURL + "/new", ward, Ward.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void findById() {

        Ward ward = restTemplate.getForObject(baseURL + "/find/1", Ward.class);

        assertNotNull(ward);

    }

    @Test
    public void update() {

        int id = 1;
        Ward ward = restTemplate.getForObject(baseURL + "/find/" + id, Ward.class);
        ward.setWardId("AS");

        restTemplate.put(baseURL + "/update/" + id, ward);

        Ward updatedDoctor = restTemplate.getForObject(baseURL + "/update/" + id, Ward.class);

        assertNotNull(updatedDoctor);

    }

    @Test
    public void delete() {

        int id = 1;
        Ward ward = restTemplate.getForObject(baseURL + "/find/" + id, Ward.class);
        assertNotNull(ward);

        restTemplate.delete(baseURL + "/delete/" + id);

        try {
            ward = restTemplate.getForObject(baseURL + "/find/" + id, Ward.class);
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