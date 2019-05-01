package me.mohammedriaz.services.hospital;

import me.mohammedriaz.domain.hospital.Room;
import me.mohammedriaz.services.Service;

import java.util.Set;

public interface RoomService extends Service<Room, Integer> {

    Set<Room> getAll();

}
