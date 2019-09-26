package me.mohammedriazkhan.factory.hospital;

import me.mohammedriazkhan.domain.hospital.Equipment;
import me.mohammedriazkhan.domain.hospital.Room;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RoomFactoryTest {

    @Test
    public void getRoom() {

        Room room = RoomFactory.getRoom("A");
        System.out.println(room);

        Assert.assertNotNull(room.getRoomId());

    }
}