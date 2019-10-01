package me.mohammedriazkhan.controller.visit;

import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.domain.patient.Patient;
import me.mohammedriazkhan.domain.visit.Visit;
import me.mohammedriazkhan.factory.employee.DoctorFactory;
import me.mohammedriazkhan.factory.patient.InPatientFactory;
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

import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VisitControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/visit";

    @Test
    public void a_create() {

        Doctor doctor = DoctorFactory.getDoctor( "Mohammed", "Khan", "1234564", "1 May 2501", "Renal Doctor", "Super Man");

        Patient aPatient = InPatientFactory.getInPatient("Mohammed", "Khan", "123135", "3213213213", 23, "1231", "1", 123, "111111");

        Visit visit = VisitFactory.getVisit(new Date().toString(), aPatient.getPatientId().toString(), doctor.getEmployeeId(), "fasd", "fasd");
        visit.setVisitId("abc");
        ResponseEntity<Visit> postResponse = restTemplate.postForEntity(baseURL + "/new", visit, Visit.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void b_findById() {

        Visit visit = restTemplate.getForObject(baseURL + "/find/abc", Visit.class);

        assertNull(visit);

    }

    @Test
    public void c_update() {

//        int id = 1;
//        Visit visit = restTemplate.getForObject(baseURL + "/find/" + "abc", Visit.class);
//        visit.setVisitDate("Today");
//
//        restTemplate.put(baseURL + "/update/" + "abc", visit);
//
//        Visit updatedDoctor = restTemplate.getForObject(baseURL + "/update/" + "abc", Visit.class);
//
//        assertNotNull(updatedDoctor);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Visit visit = restTemplate.getForObject(baseURL + "/find/" + "abc", Visit.class);
        assertNull(visit);

        restTemplate.delete(baseURL + "/delete/" + "abc");

        try {
            visit = restTemplate.getForObject(baseURL + "/find/" + "abc", Visit.class);
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
