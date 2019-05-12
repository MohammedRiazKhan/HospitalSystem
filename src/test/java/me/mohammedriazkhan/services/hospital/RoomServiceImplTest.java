package me.mohammedriazkhan.services.hospital;

import me.mohammedriazkhan.domain.hospital.Room;
import me.mohammedriazkhan.factories.hospital.RoomFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.services.Impl.RoomServiceImpl;

public class RoomServiceImplTest {

    RoomServiceImpl roomService;

    @Before
    public void setUp() throws Exception {

        roomService = new RoomServiceImpl();

    }

    @Test
    public void create() {

        Room room = RoomFactory.getRoom(1, null);
        roomService.create(room);

        Assert.assertNotNull(roomService.getAll());


    }

    @Test
    public void read() {


        Room room = RoomFactory.getRoom(1, null);
        roomService.create(room);

        Assert.assertNotNull(roomService.getAll());

        Room room1 = roomService.read(room.getRoomId());

        Assert.assertEquals(room, room1);


    }

    @Test
    public void update() {

        Room room = RoomFactory.getRoom(1, null);
        roomService.create(room);

        Assert.assertNotNull(roomService.getAll());

        Room room1 = RoomFactory.getRoom(2, null);
        room1.setRoomId(room.getRoomId());
        roomService.update(room1);

        Room update = roomService.read(room1.getRoomId());

        Assert.assertEquals(room1, update);

    }

    @Test
    public void delete() {

        Room room = RoomFactory.getRoom(1, null);
        roomService.create(room);

        Assert.assertNotNull(roomService.getAll());

        roomService.delete(room.getRoomId());

        Room room1 = roomService.read(room.getRoomId());

        Assert.assertNull(room1);

    }
}