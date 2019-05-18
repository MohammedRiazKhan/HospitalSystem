package me.mohammedriazkhan.repository.hospital;

import me.mohammedriazkhan.domain.hospital.Room;
import me.mohammedriazkhan.factory.hospital.RoomFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.repository.hospital.impl.RoomRepositoryImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomRepositoryTest {


    @Autowired
    private RoomRepositoryImpl roomRepository;


    @Test
    public void create() {

        Room room = RoomFactory.getRoom(1, null);
        roomRepository.create(room);

        assertNotNull(roomRepository.getAll());


    }

    @Test
    public void read() {


        Room room = RoomFactory.getRoom(1, null);
        roomRepository.create(room);

        assertNotNull(roomRepository.getAll());

        Room room1 = roomRepository.read(room.getRoomId());

        assertEquals(room, room1);


    }

    @Test
    public void update() {

        Room room = RoomFactory.getRoom(1, null);
        roomRepository.create(room);

        assertNotNull(roomRepository.getAll());

        Room room1 = RoomFactory.getRoom(2, null);
        room1.setRoomId(room.getRoomId());
        roomRepository.update(room1);

        Room update = roomRepository.read(room1.getRoomId());

        assertEquals(room1, update);

    }

    @Test
    public void delete() {

        Room room = RoomFactory.getRoom(1, null);
        roomRepository.create(room);

        assertNotNull(roomRepository.getAll());

        roomRepository.delete(room.getRoomId());

        Room room1 = roomRepository.read(room.getRoomId());

        assertNull(room1);

    }
}