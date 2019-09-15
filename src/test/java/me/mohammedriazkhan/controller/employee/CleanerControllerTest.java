package me.mohammedriazkhan.controller.employee;

import me.mohammedriazkhan.domain.employee.Cleaner;
import me.mohammedriazkhan.factory.employee.CleanerFactory;
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
public class CleanerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/cleaner";

    @Test
    public void create() {

        Cleaner cleaner = CleanerFactory.getCleaner();
        cleaner.setEmployeeId("Asdf");

        ResponseEntity<Cleaner> postResponse = restTemplate.postForEntity(baseURL + "/new", cleaner, Cleaner.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void findById() {

        Cleaner cleaner = restTemplate.getForObject(baseURL + "/find/Asdf", Cleaner.class);

        assertNotNull(cleaner);

    }

    @Test
    public void update() {

        int id = 1;
        Cleaner cleaner = restTemplate.getForObject(baseURL + "/find/" + "Asdf", Cleaner.class);
        cleaner.setFirstName("Mohammed");

        restTemplate.put(baseURL + "/update/" + "Asdf", cleaner);

        Cleaner updatedCleaner = restTemplate.getForObject(baseURL + "/update/" + "Asdf", Cleaner.class);

        assertNotNull(updatedCleaner);

    }

    @Test
    public void delete() {

        Cleaner cleaner = restTemplate.getForObject(baseURL + "/find/" + "Asdf", Cleaner.class);
        assertNotNull(cleaner);

        restTemplate.delete(baseURL + "/delete/" + "Asdf");

        try {
            cleaner = restTemplate.getForObject(baseURL + "/find/" + "Asdf", Cleaner.class);
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