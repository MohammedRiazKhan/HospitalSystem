package me.mohammedriazkhan.controller.patient;

import me.mohammedriazkhan.domain.patient.Report;
import me.mohammedriazkhan.factory.patient.ReportFactory;
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
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReportControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/report";

    @Before
    public void addDummyData(){

        Report report = ReportFactory.getReport("Todays Report", "There was a slight bruise on my left pinky toe", "21 Sep 2019", "1");

        restTemplate.postForEntity(baseURL + "/new", report, Report.class);

    }

    @Test
    public void a_create() {

        Report report = ReportFactory.getReport("Text", "Body", null, null);
        report.setReportId("Afsd");
        ResponseEntity<Report> postResponse = restTemplate.postForEntity(baseURL + "/new", report, Report.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void b_findById() {

        Report report = restTemplate.getForObject(baseURL + "/find/Afsd", Report.class);

        assertNotNull(report);

    }

    @Test
    public void c_update() {


        Report report = ReportFactory.getReport("Text", "Body", null, null);
        report.setReportId("Afsd");
        ResponseEntity<Report> postResponse = restTemplate.postForEntity(baseURL + "/new", report, Report.class);

        Report reportIn = restTemplate.getForObject(baseURL + "/find/" + "Afsd", Report.class);
        report.setDateRange("fasd");

        restTemplate.put(baseURL + "/update/" + "Afsd", reportIn);

        Report updatedDoctor = restTemplate.getForObject(baseURL + "/update/" + "Afsd", Report.class);

        assertNotNull(updatedDoctor);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Report report = restTemplate.getForObject(baseURL + "/find/" + "Afsd", Report.class);
        assertNotNull(report);

        restTemplate.delete(baseURL + "/delete/" + "Afsd");

        try {
            report = restTemplate.getForObject(baseURL + "/find/" + "Afsd", Report.class);
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

    @Test
    public void whenCorrectCredentialsWillBe200() throws Exception {

        ResponseEntity<String> response = restTemplate.withBasicAuth("admin", "admin").getForEntity(baseURL + "/getall", String.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());

        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    public void whenIncorrectCredentialsWillBe401() throws Exception {

        ResponseEntity<String> response = restTemplate.withBasicAuth("admin", "admins").getForEntity(baseURL + "/getall", String.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());

        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());

    }
}