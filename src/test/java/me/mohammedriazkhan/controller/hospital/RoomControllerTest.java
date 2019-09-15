package me.mohammedriazkhan.controller.hospital;

import me.mohammedriazkhan.domain.hospital.Room;
import me.mohammedriazkhan.factory.hospital.RoomFactory;
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

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoomControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/hospital/room";

    @Test
    public void a_create() {

        Room room = RoomFactory.getRoom( null);
        room.setRoomId("as");

        ResponseEntity<Room> postResponse = restTemplate.postForEntity(baseURL + "/new", room, Room.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void b_findById() {

        Room room  = restTemplate.getForObject(baseURL + "/find/as", Room.class);

        assertNotNull(room);

    }

    @Test
    public void c_update() {

        int id = 1;
        Room room  = restTemplate.getForObject(baseURL + "/find/" + "as", Room.class);


        restTemplate.put(baseURL + "/update/" + "as", room);

        Room updatedDoctor = restTemplate.getForObject(baseURL + "/update/" + "as", Room.class);

        assertNotNull(updatedDoctor);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Room room = restTemplate.getForObject(baseURL + "/find/" + "as", Room.class);
        assertNotNull(room);

        restTemplate.delete(baseURL + "/delete/" + "as");

        try {
            room = restTemplate.getForObject(baseURL + "/find/" + "as", Room.class);
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