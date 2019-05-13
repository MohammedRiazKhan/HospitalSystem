package me.mohammedriazkhan.controller.visit;

import me.mohammedriazkhan.domain.visit.Visit;
import me.mohammedriazkhan.factory.visit.VisitFactory;
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
@FixMethodOrder(MethodSorters.JVM)
public class VisitControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/visit";

    @Test
    public void create() {

        Visit visit = VisitFactory.getVisit(1, "fasd", null, null, null, null, null);

        ResponseEntity<Visit> postResponse = restTemplate.postForEntity(baseURL + "/new", visit, Visit.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void findById() {

        Visit visit = restTemplate.getForObject(baseURL + "/find/1", Visit.class);

        assertNotNull(visit);

    }

    @Test
    public void update() {

        int id = 1;
        Visit visit = restTemplate.getForObject(baseURL + "/find/" + id, Visit.class);
        visit.setVisitDate("Today");

        restTemplate.put(baseURL + "/update/" + id, visit);

        Visit updatedDoctor = restTemplate.getForObject(baseURL + "/update/" + id, Visit.class);

        assertNotNull(updatedDoctor);

    }

    @Test
    public void delete() {

        int id = 1;
        Visit visit = restTemplate.getForObject(baseURL + "/find/" + id, Visit.class);
        assertNotNull(visit);

        restTemplate.delete(baseURL + "/delete/" + id);

        try {
            visit = restTemplate.getForObject(baseURL + "/find/" + id, Visit.class);
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