package me.mohammedriazkhan.services.hospital;

import me.mohammedriazkhan.domain.hospital.Room;
import me.mohammedriazkhan.services.Service;

import java.util.Set;

public interface RoomService extends Service<Room, Integer> {

    Set<Room> getAll();

}
