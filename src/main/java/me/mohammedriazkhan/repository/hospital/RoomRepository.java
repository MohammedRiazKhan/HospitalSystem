package me.mohammedriazkhan.repository.hospital;

import me.mohammedriazkhan.domain.hospital.Room;
import me.mohammedriazkhan.repository.Repository;

import java.util.Set;

public interface RoomRepository extends Repository<Room, Integer> {


    Set<Room> getAll();


}
