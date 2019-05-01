package me.mohammedriaz.factories.hospital;

import me.mohammedriaz.domain.hospital.Equipment;
import me.mohammedriaz.domain.hospital.Room;
import me.mohammedriaz.utility.IDGenerator;

import java.util.List;

public class RoomFactory {

    public static Room getRoom(int roomId, List<Equipment> equipment) {
        return (Room) new Room.RoomBuilder()
                .roomId(IDGenerator.genId())
                .equipment(equipment)
                .build();
    }




}
