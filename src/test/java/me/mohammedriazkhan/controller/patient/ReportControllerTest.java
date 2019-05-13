package me.mohammedriazkhan.controller.patient;

import me.mohammedriazkhan.domain.patient.Report;
import me.mohammedriazkhan.factory.patient.ReportFactory;
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
public class ReportControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/report";

    @Test
    public void create() {

        Report report = ReportFactory.getReport(1, "Text", "Body", null, null);
        report.setReportId(1);
        ResponseEntity<Report> postResponse = restTemplate.postForEntity(baseURL + "/new", report, Report.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void findById() {

        Report report = restTemplate.getForObject(baseURL + "/find/1", Report.class);

        assertNotNull(report);

    }

    @Test
    public void update() {

        int id = 1;
        Report report = restTemplate.getForObject(baseURL + "/find/" + id, Report.class);
        report.setTitle("Official Report");

        restTemplate.put(baseURL + "/update/" + id, report);

        Report updatedDoctor = restTemplate.getForObject(baseURL + "/update/" + id, Report.class);

        assertNotNull(updatedDoctor);

    }

    @Test
    public void delete() {

        int id = 1;
        Report report = restTemplate.getForObject(baseURL + "/find/" + id, Report.class);
        assertNotNull(report);

        restTemplate.delete(baseURL + "/delete/" + id);

        try {
            report = restTemplate.getForObject(baseURL + "/find/" + id, Report.class);
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