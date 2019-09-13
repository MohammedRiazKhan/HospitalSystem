package me.mohammedriazkhan.controller.hospital;

import me.mohammedriazkhan.domain.hospital.Department;
import me.mohammedriazkhan.factory.hospital.DepartmentFactory;
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
public class DepartmentControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/dept";

    @Test
    public void create() {

        Department department = DepartmentFactory.getDepartment( "Afsd", null, null);
        department.setDepartmentId("Afsd");

        ResponseEntity<Department> postResponse = restTemplate.postForEntity(baseURL + "/new", department, Department.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void findById() {

        Department department = restTemplate.getForObject(baseURL + "/find/1", Department.class);

        assertNotNull(department);

    }

    @Test
    public void update() {

        int id = 1;
        Department department = restTemplate.getForObject(baseURL + "/find/" + id, Department.class);


        restTemplate.put(baseURL + "/update/" + id, department);

        Department updatedDoctor = restTemplate.getForObject(baseURL + "/update/" + id, Department.class);

        assertNotNull(updatedDoctor);

    }

    @Test
    public void delete() {

        int id = 1;
        Department department = restTemplate.getForObject(baseURL + "/find/" + id, Department.class);
        assertNotNull(department);

        restTemplate.delete(baseURL + "/delete/" + id);

        try {
            department = restTemplate.getForObject(baseURL + "/find/" + id, Department.class);
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