package me.mohammedriazkhan.repository.hospital.impl;

import me.mohammedriazkhan.domain.hospital.Room;
import me.mohammedriazkhan.repository.hospital.RoomRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
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

    public Room find(int id) {
        return rooms.stream().filter(room -> room.getRoomId() == id).findAny().orElse(null);
    }

    @Override
    public Room create(Room room) {

        rooms.add(room);

        return room;
    }

    @Override
    public Room read(Integer id) {
        Room room = find(id);

        if(room == null){
            return null;
        }
        else {
            return room;
        }
    }

    @Override
    public Room update(Room room) {

        Room room1 = find(room.getRoomId());
        if(rooms.contains(room1)){
            rooms.remove(room1);
            rooms.add(room);
        }

        return room1;
    }

    @Override
    public void delete(Integer id) {

        Room room = find(id);
        rooms.remove(room);

    }

    @Override
    public Set<Room> getAll() {
        return rooms;
    }

}
