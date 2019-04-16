package factories.hospital;

import domain.hospital.Equipment;
import domain.hospital.Room;
import utility.IDGenerator;

import java.util.List;

public class RoomFactory {

    public static Room getRoom(int roomId, List<Equipment> equipment) {
        return (Room) new Room.RoomBuilder()
                .roomId(IDGenerator.genId())
                .build();
    }

}
