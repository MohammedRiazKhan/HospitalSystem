package me.mohammedriaz.repositories.hospital;

import me.mohammedriaz.domain.hospital.Room;
import me.mohammedriaz.repositories.Repository;

import java.util.Set;

public interface RoomRepository extends Repository<Room, Integer> {


    Set<Room> getAll();


}
