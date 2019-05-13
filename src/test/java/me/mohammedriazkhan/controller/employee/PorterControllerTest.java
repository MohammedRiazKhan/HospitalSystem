package me.mohammedriazkhan.controller.employee;

import me.mohammedriazkhan.domain.employee.Porter;
import me.mohammedriazkhan.factory.employee.PorterFactory;
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
public class PorterControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/employee/porter";

    @Test
    public void create() {

        Porter porter = PorterFactory.getPorter(1, "Jake", "Paul", "00001321");
        porter.setEmployeeId(1);

        ResponseEntity<Porter> postResponse = restTemplate.postForEntity(baseURL + "/new", porter, Porter.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void findById() {

        Porter porter = restTemplate.getForObject(baseURL + "/find/1", Porter.class);

        assertNotNull(porter);

    }

    @Test
    public void update() {

        int id = 1;
        Porter porter = restTemplate.getForObject(baseURL + "/find/" + id, Porter.class);
        porter.setFirstName("Mohammed");

        restTemplate.put(baseURL + "/update/" + id, porter);

        Porter updatedDoctor = restTemplate.getForObject(baseURL + "/update/" + id, Porter.class);

        assertNotNull(updatedDoctor);

    }

    @Test
    public void delete() {

        int id = 1;
        Porter porter = restTemplate.getForObject(baseURL + "/find/" + id, Porter.class);
        assertNotNull(porter);

        restTemplate.delete(baseURL + "/delete/" + id);

        try {
            porter = restTemplate.getForObject(baseURL + "/find/" + id, Porter.class);
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