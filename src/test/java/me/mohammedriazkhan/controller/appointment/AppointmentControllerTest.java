package me.mohammedriazkhan.controller.appointment;

import me.mohammedriazkhan.domain.appoinment.Appointment;
import me.mohammedriazkhan.factory.appointment.AppointmentFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppointmentControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/appointment";

    @Test
    public void create() {

        Appointment appointment = AppointmentFactory.getAppointment(1, "1 May 19", null);
        appointment.setAppointmentId(1);

        ResponseEntity<Appointment> postResponse = restTemplate.postForEntity(baseURL + "/new", appointment, Appointment.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void findById() {

        //returns an object as a pojo thus getForObject
        Appointment appointment = restTemplate.getForObject(baseURL + "/find/1", Appointment.class);

        assertNotNull(appointment);

    }

    @Test
    public void update() {

        int id = 1;
        Appointment appointment = restTemplate.getForObject(baseURL + "/find/" + id, Appointment.class);
        appointment.setBookingDate("13 May 19");

        restTemplate.put(baseURL + "/update/" + id, appointment);

        Appointment appointmentUpdated = restTemplate.getForObject(baseURL + "/update/" + id, Appointment.class);

        assertNotNull(appointmentUpdated);

    }

    @Test
    public void delete() {

        int id = 1;
        Appointment appointment = restTemplate.getForObject(baseURL + "/find/" + id, Appointment.class);
        assertNotNull(appointment);

        restTemplate.delete(baseURL + "/delete/" + id);

        try {
            appointment = restTemplate.getForObject(baseURL + "/find/" + id, Appointment.class);
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