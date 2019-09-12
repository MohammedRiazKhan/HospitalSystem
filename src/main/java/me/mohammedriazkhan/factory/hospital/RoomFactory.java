package me.mohammedriazkhan.factory.hospital;

import me.mohammedriazkhan.domain.hospital.Equipment;
import me.mohammedriazkhan.domain.hospital.Room;
import me.mohammedriazkhan.helper.IDGenerator;


import java.util.List;

public class RoomFactory {

    public static Room getRoom(List<Equipment> equipment) {
        return new Room.RoomBuilder()
                .roomId(IDGenerator.generateId())
                .equipment(equipment)
                .build();
    }




}
