package me.mohammedriazkhan.controller.hospital;

import me.mohammedriazkhan.domain.hospital.Department;
import me.mohammedriazkhan.domain.hospital.Room;
import me.mohammedriazkhan.domain.hospital.Ward;
import me.mohammedriazkhan.factory.hospital.DepartmentFactory;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/dept";

    @Test
    public void a_create() {

        List<Ward> ward = new ArrayList<>();
        List<Room> rooms = new ArrayList<>();

        Department department = DepartmentFactory.getDepartment("Ward1", "Room1");
        department.setDepartmentId("a");

        ResponseEntity<Department> postResponse = restTemplate.postForEntity(baseURL + "/new", department, Department.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void b_findById() {

        Department department = restTemplate.getForObject(baseURL + "/find/a", Department.class);

        assertNull(department);

    }

    @Test
    public void c_update() {

        int id = 1;
        Department department = restTemplate.getForObject(baseURL + "/find/" + "Afsd", Department.class);


        restTemplate.put(baseURL + "/update/" + "Afsd", department);

        Department updatedDoctor = restTemplate.getForObject(baseURL + "/update/" + "Afsd", Department.class);

        assertNotNull(updatedDoctor);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Department department = restTemplate.getForObject(baseURL + "/find/" + "Afsd", Department.class);
        assertNull(department);

        restTemplate.delete(baseURL + "/delete/" + "Afsd");

        try {
            department = restTemplate.getForObject(baseURL + "/find/" + "Afsd", Department.class);
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