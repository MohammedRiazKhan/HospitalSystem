package me.mohammedriazkhan.factory.hospital;

import me.mohammedriazkhan.domain.hospital.Equipment;
import me.mohammedriazkhan.domain.hospital.Room;


import java.util.List;

public class RoomFactory {

    public static Room getRoom(int roomId, List<Equipment> equipment) {
        return new Room.RoomBuilder()
                .roomId(roomId)
                .equipment(equipment)
                .build();
    }




}
