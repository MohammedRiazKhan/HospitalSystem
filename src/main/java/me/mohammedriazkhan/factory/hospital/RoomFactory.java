package me.mohammedriazkhan.factory.hospital;

import me.mohammedriazkhan.domain.hospital.Equipment;
import me.mohammedriazkhan.domain.hospital.Room;
import me.mohammedriazkhan.utility.IDGenerator;

import java.util.List;

public class RoomFactory {

    public static Room getRoom(int roomId, List<Equipment> equipment) {
        return (Room) new Room.RoomBuilder()
                .roomId(IDGenerator.genId())
                .equipment(equipment)
                .build();
    }




}
