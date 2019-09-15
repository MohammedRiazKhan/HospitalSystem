package me.mohammedriazkhan.controller.hospital;

import me.mohammedriazkhan.domain.hospital.Ward;
import me.mohammedriazkhan.factory.hospital.WardFactory;
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
public class WardControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/department/ward";

    @Test
    public void a_create() {

        Ward ward = WardFactory.getWard("A");
        ward.setWardId("as");

        ResponseEntity<Ward> postResponse = restTemplate.postForEntity(baseURL + "/new", ward, Ward.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void b_findById() {

        Ward ward = restTemplate.getForObject(baseURL + "/find/as", Ward.class);

        assertNotNull(ward);

    }

    @Test
    public void c_update() {

        int id = 1;
        Ward ward = restTemplate.getForObject(baseURL + "/find/" + "as", Ward.class);
        ward.setWardId("AS");

        restTemplate.put(baseURL + "/update/" + "as", ward);

        Ward updatedDoctor = restTemplate.getForObject(baseURL + "/update/" + "as", Ward.class);

        assertNotNull(updatedDoctor);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Ward ward = restTemplate.getForObject(baseURL + "/find/" + "as", Ward.class);
        assertNotNull(ward);

        restTemplate.delete(baseURL + "/delete/" + "as");

        try {
            ward = restTemplate.getForObject(baseURL + "/find/" + "as", Ward.class);
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