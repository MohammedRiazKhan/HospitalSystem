package me.mohammedriazkhan.controller.employee;

import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.factory.employee.DoctorFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DoctorControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/doctor";

    @Test
    public void create() {

        Doctor doctor = DoctorFactory.getDoctor("Riaz", "Khan", "Renal");
        doctor.setEmployeeId(1);

        ResponseEntity<Doctor> postResponse = restTemplate.postForEntity(baseURL + "/new", doctor, Doctor.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void findById() {

        Doctor doctor = restTemplate.getForObject(baseURL + "/find/1", Doctor.class);

        assertNotNull(doctor);

    }

    @Test
    public void update() {

        int id = 1;
        Doctor doctor = restTemplate.getForObject(baseURL + "/find/" + id, Doctor.class);
        doctor.setFirstName("Mohammed");

        restTemplate.put(baseURL + "/update/" + id, doctor);

        Doctor updatedDoctor = restTemplate.getForObject(baseURL + "/update/" + id, Doctor.class);

        assertNotNull(updatedDoctor);

    }

    @Test
    public void delete() {

        int id = 1;
        Doctor doctor = restTemplate.getForObject(baseURL + "/find/" + id, Doctor.class);
        assertNotNull(doctor);

        restTemplate.delete(baseURL + "/delete/" + id);

        try {
            doctor = restTemplate.getForObject(baseURL + "/find/" + id, Doctor.class);
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