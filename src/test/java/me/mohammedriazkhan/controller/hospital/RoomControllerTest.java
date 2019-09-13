package me.mohammedriazkhan.controller.hospital;

import me.mohammedriazkhan.domain.hospital.Room;
import me.mohammedriazkhan.factory.hospital.RoomFactory;
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
public class RoomControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/hospital/room";

    @Test
    public void create() {

        Room room = RoomFactory.getRoom( null);

        ResponseEntity<Room> postResponse = restTemplate.postForEntity(baseURL + "/new", room, Room.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void findById() {

        Room room  = restTemplate.getForObject(baseURL + "/find/1", Room.class);

        assertNotNull(room);

    }

    @Test
    public void update() {

        int id = 1;
        Room room  = restTemplate.getForObject(baseURL + "/find/" + id, Room.class);


        restTemplate.put(baseURL + "/update/" + id, room);

        Room updatedDoctor = restTemplate.getForObject(baseURL + "/update/" + id, Room.class);

        assertNotNull(updatedDoctor);

    }

    @Test
    public void delete() {

        int id = 1;
        Room room = restTemplate.getForObject(baseURL + "/find/" + id, Room.class);
        assertNotNull(room);

        restTemplate.delete(baseURL + "/delete/" + id);

        try {
            room = restTemplate.getForObject(baseURL + "/find/" + id, Room.class);
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