package repositories.Impl;

import domain.hospital.Room;
import repositories.hospital.RoomRepository;

import java.util.HashSet;
import java.util.Set;

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
    public void create(Room room) {

        rooms.add(room);

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
    public void update(Room room) {

        Room room1 = find(room.getRoomId());
        if(rooms.contains(room1)){
            rooms.remove(room1);
            rooms.add(room);
        }

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
