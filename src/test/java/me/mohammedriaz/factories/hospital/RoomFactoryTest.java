package me.mohammedriaz.factories.hospital;

import me.mohammedriaz.domain.hospital.Equipment;
import me.mohammedriaz.domain.hospital.Room;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RoomFactoryTest {

    @Test
    public void getRoom() {

        List<Equipment> equipment = new ArrayList<>();

        Room room = RoomFactory.getRoom(1, equipment);

        Assert.assertNotNull(room.getRoomId());

    }
}