package me.mohammedriazkhan.controller.employee;

import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.factory.employee.DoctorFactory;
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

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DoctorControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/doctor";

    @Test
    public void a_create() {

        Doctor doctor = DoctorFactory.getDoctor("Riaz", "Khan", "Renal");
        doctor.setEmployeeId("Afsd");

        ResponseEntity<Doctor> postResponse = restTemplate.postForEntity(baseURL + "/new", doctor, Doctor.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void b_findById() {

        Doctor doctor = restTemplate.getForObject(baseURL + "/find/" + "Afsd", Doctor.class);

        assertNotNull(doctor);

    }

    @Test
    public void c_update() {

        int id = 1;
        Doctor doctor = restTemplate.getForObject(baseURL + "/find/" + "Afsd", Doctor.class);
        doctor.setFirstName("Mohammed");

        restTemplate.put(baseURL + "/update/" + "Afsd", doctor);

        Doctor updatedDoctor = restTemplate.getForObject(baseURL + "/update/" + "Afsd", Doctor.class);

        assertNotNull(updatedDoctor);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Doctor doctor = restTemplate.getForObject(baseURL + "/find/" + "Afsd", Doctor.class);
        assertNotNull(doctor);

        restTemplate.delete(baseURL + "/delete/" + "Afsd");

        try {
            doctor = restTemplate.getForObject(baseURL + "/find/" + "Afsd", Doctor.class);
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