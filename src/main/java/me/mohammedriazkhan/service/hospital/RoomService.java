package me.mohammedriazkhan.service.hospital;

import me.mohammedriazkhan.domain.hospital.Room;
import me.mohammedriazkhan.service.Service;

import java.util.Set;

public interface RoomService extends Service<Room, Integer> {

    Set<Room> getAll();

}
