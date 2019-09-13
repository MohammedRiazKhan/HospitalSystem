package me.mohammedriazkhan.repository.hospital.impl;

import me.mohammedriazkhan.domain.hospital.Room;
import me.mohammedriazkhan.repository.hospital.RoomRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository("RoomInMemory")
public class RoomRepositoryImpl implements RoomRepository{

    private static RoomRepositoryImpl roomRepository = null;
    private Set<Room> rooms;

    public RoomRepositoryImpl(){
        rooms = new HashSet<>();
    }

    public static RoomRepositoryImpl getRoomRepository() {
        if(roomRepository == null){
            return new RoomRepositoryImpl();
        }
        return roomRepository;
    }

    @Override
    public Room create(Room room) {

        rooms.add(room);
        return room;
    }

    @Override
    public Room read(String id) {
       return rooms.stream().filter(room -> room.getRoomId().equals(id)).findAny().orElse(null);
    }

    @Override
    public Room update(Room room) {

        Room inDB = read(room.getRoomId());

        if(inDB != null){
            rooms.remove(inDB);
            rooms.add(room);
            return room;
        }

        return null;
    }

    @Override
    public void delete(String id) {

        Room inDB = read(id);
        rooms.remove(inDB);

    }

    @Override
    public Set<Room> getAll() {
        return rooms;
    }

}
