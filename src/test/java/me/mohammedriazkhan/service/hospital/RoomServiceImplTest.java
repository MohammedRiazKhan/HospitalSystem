package me.mohammedriazkhan.service.hospital;

import me.mohammedriazkhan.domain.hospital.Room;
import me.mohammedriazkhan.factory.hospital.RoomFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.service.hospital.impl.RoomServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomServiceImplTest {

    @Autowired
    private RoomServiceImpl roomService;

    @Test
    public void create() {

        Room room = RoomFactory.getRoom(1, null);
        roomService.create(room);

        assertNotNull(roomService.getAll());


    }

    @Test
    public void read() {


        Room room = RoomFactory.getRoom(1, null);
        roomService.create(room);

        assertNotNull(roomService.getAll());

        Room room1 = roomService.read(room.getRoomId());

        assertEquals(room, room1);


    }

    @Test
    public void update() {

        Room room = RoomFactory.getRoom(1, null);
        roomService.create(room);

        assertNotNull(roomService.getAll());

        Room room1 = RoomFactory.getRoom(2, null);
        room1.setRoomId(room.getRoomId());
        roomService.update(room1);

        Room update = roomService.read(room1.getRoomId());

        assertEquals(room1, update);

    }

    @Test
    public void delete() {

        Room room = RoomFactory.getRoom(1, null);
        roomService.create(room);

        assertNotNull(roomService.getAll());

        roomService.delete(room.getRoomId());

        Room room1 = roomService.read(room.getRoomId());

        assertNull(room1);

    }
}