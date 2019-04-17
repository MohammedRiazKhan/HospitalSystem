package factories.hospital;

import domain.hospital.Equipment;
import domain.hospital.Room;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RoomFactoryTest {

    @Test
    public void getRoom() {

        List<Equipment> equipment = new ArrayList<>();

        Room room = RoomFactory.getRoom(1, equipment);

        Assert.assertNotNull(room.getRoomId());

    }
}