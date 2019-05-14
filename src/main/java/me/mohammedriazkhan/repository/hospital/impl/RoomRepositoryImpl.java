package me.mohammedriazkhan.repository.hospital.impl;

import me.mohammedriazkhan.domain.hospital.Room;
import me.mohammedriazkhan.repository.hospital.RoomRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository("InMemory")
public class RoomRepositoryImpl implements RoomRepository{

    private static RoomRepositoryImpl roomRepository = null;
    private Map<Integer, Room> rooms;

    public RoomRepositoryImpl(){
        rooms = new HashMap<>();
    }

    public static RoomRepositoryImpl getRoomRepository() {
        if(roomRepository == null){
            return new RoomRepositoryImpl();
        }
        return roomRepository;
    }

   /* public Room find(int id) {
        return rooms.stream().filter(room -> room.getRoomId() == id).findAny().orElse(null);
    }*/

    @Override
    public Room create(Room room) {

        rooms.put(room.getRoomId(), room);
        return room;
    }

    @Override
    public Room read(Integer id) {
       return rooms.get(id);
    }

    @Override
    public Room update(Room room) {

        rooms.replace(room.getRoomId(), room);
        return rooms.get(room.getRoomId());
    }

    @Override
    public void delete(Integer id) {

       rooms.remove(id);

    }

    @Override
    public Set<Room> getAll() {
        return new HashSet<>(rooms.values());
    }

}
