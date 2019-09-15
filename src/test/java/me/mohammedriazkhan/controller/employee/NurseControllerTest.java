package me.mohammedriazkhan.controller.employee;

import me.mohammedriazkhan.domain.employee.Nurse;
import me.mohammedriazkhan.factory.employee.NurseFactory;
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
public class NurseControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/employee/nurse";

    @Test
    public void a_create() {

        Nurse nurse = NurseFactory.getNurse("Riaz", "Khan", "1234", "Nurse Duh", "Today", null);
        nurse.setEmployeeId("Afsd");
        assertNotNull(nurse);

        ResponseEntity<Nurse> postResponse = restTemplate.postForEntity(baseURL + "/new", nurse, Nurse.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void b_findById() {

        Nurse nurse = restTemplate.getForObject(baseURL + "/find/" + "Afsd", Nurse.class);

        assertNotNull(nurse);

    }

    @Test
    public void c_update() {

        Nurse nurse = restTemplate.getForObject(baseURL + "/find/" + "Afsd", Nurse.class);
        nurse.setFirstName("Mohammed");

        restTemplate.put(baseURL + "/update/" + "Afsd", nurse);

        Nurse updatedNurse = restTemplate.getForObject(baseURL + "/update/" + "Afsd", Nurse.class);

        assertNotNull(updatedNurse);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Nurse nurse = restTemplate.getForObject(baseURL + "/find/" + "Afsd", Nurse.class);
        assertNotNull(nurse);

        restTemplate.delete(baseURL + "/delete/" + "Afsd");

        try {
            nurse = restTemplate.getForObject(baseURL + "/find/" + "Afsd", Nurse.class);
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