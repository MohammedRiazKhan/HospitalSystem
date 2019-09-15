package me.mohammedriazkhan.controller.appointment;

import me.mohammedriazkhan.domain.appoinment.Appointment;
import me.mohammedriazkhan.factory.appointment.AppointmentFactory;
import org.junit.Before;
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

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppointmentControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/appointment";

    @Test
    public void a_create() {

        Appointment appointment = AppointmentFactory.getAppointment("1 May 19", null);
        appointment.setAppointmentId("fas");

        ResponseEntity<Appointment> postResponse = restTemplate.postForEntity(baseURL + "/new", appointment, Appointment.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void b_findById() {

        //returns an object as a pojo thus getForObject
        Appointment lookingFor = restTemplate.getForObject(baseURL + "/find/" + "fas", Appointment.class);

        assertNotNull(lookingFor);

    }

    @Test
    public void c_update() {

        Appointment appointment = restTemplate.getForObject(baseURL + "/find/" + "fas", Appointment.class);
        appointment.setBookingDate("13 May 19");

        restTemplate.put(baseURL + "/update/" + "fas", appointment);

        Appointment appointmentUpdated = restTemplate.getForObject(baseURL + "/update/" + "fas", Appointment.class);

        assertNotNull(appointmentUpdated);

    }

    @Test
    public void e_delete() {

        Appointment appointment = restTemplate.getForObject(baseURL + "/find/" + "fas", Appointment.class);
        assertNotNull(appointment);

        restTemplate.delete(baseURL + "/delete/" + "fas");

        try {
            appointment = restTemplate.getForObject(baseURL + "/find/" + "fas", Appointment.class);
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