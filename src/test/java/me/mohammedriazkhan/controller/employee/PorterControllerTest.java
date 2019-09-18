package me.mohammedriazkhan.controller.employee;

import me.mohammedriazkhan.domain.employee.Porter;
import me.mohammedriazkhan.factory.employee.PorterFactory;
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
public class PorterControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/employee/porter";

    @Test
    public void a_create() {

        Porter porter = PorterFactory.getPorter("Mohammed Riaz", "Khan", "1234564", "1 May 2501", "Renal Doctor", "SuperKey");
        porter.setEmployeeId("f");

        ResponseEntity<Porter> postResponse = restTemplate.postForEntity(baseURL + "/new", porter, Porter.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void b_findById() {

        Porter porter = restTemplate.getForObject(baseURL + "/find/f", Porter.class);

        assertNotNull(porter);

    }

    @Test
    public void c_update() {

        int id = 1;
        Porter porter = restTemplate.getForObject(baseURL + "/find/" + "f", Porter.class);
        porter.setFirstName("Mohammed");

        restTemplate.put(baseURL + "/update/" + "f", porter);

        Porter updatedDoctor = restTemplate.getForObject(baseURL + "/update/" + "f", Porter.class);

        assertNotNull(updatedDoctor);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Porter porter = restTemplate.getForObject(baseURL + "/find/" + "f", Porter.class);
        assertNotNull(porter);

        restTemplate.delete(baseURL + "/delete/" + "f");

        try {
            porter = restTemplate.getForObject(baseURL + "/find/" + "f", Porter.class);
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