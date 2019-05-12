package me.mohammedriazkhan.repositories.hospital;

import me.mohammedriazkhan.domain.hospital.Room;
import me.mohammedriazkhan.repositories.Repository;

import java.util.Set;

public interface RoomRepository extends Repository<Room, Integer> {


    Set<Room> getAll();


}
