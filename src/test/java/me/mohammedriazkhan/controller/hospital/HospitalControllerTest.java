package me.mohammedriazkhan.controller.hospital;

import me.mohammedriazkhan.domain.hospital.Department;
import me.mohammedriazkhan.domain.hospital.Hospital;
import me.mohammedriazkhan.factory.hospital.HospitalFactory;
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
public class HospitalControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/hospital";

    @Test
    public void a_create() {

        List<Department> departmentList = new ArrayList<>();

        //Hospital
        Hospital hospital = HospitalFactory.getHospital("Greys Anamtomy", departmentList);

        ResponseEntity<Hospital> postResponse = restTemplate.postForEntity(baseURL + "/new", hospital, Hospital.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void b_findById() {

        Hospital hospital = restTemplate.getForObject(baseURL + "/find/as", Hospital.class);

        assertNull(hospital);

    }

    @Test
    public void c_update() {

        int id = 1;
        Hospital hospital  = restTemplate.getForObject(baseURL + "/find/" + "as", Hospital.class);


        restTemplate.put(baseURL + "/update/" + "as", hospital);

        Hospital updatedDoctor = restTemplate.getForObject(baseURL + "/update/" + "as", Hospital.class);

        assertNotNull(updatedDoctor);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Hospital hospital = restTemplate.getForObject(baseURL + "/find/" + "as", Hospital.class);
        assertNull(hospital);

        restTemplate.delete(baseURL + "/delete/" + "as");

        try {
            hospital = restTemplate.getForObject(baseURL + "/find/" + "as", Hospital.class);
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