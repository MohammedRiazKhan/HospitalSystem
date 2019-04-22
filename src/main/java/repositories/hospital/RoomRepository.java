package repositories.hospital;

import domain.hospital.Room;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public class RoomRepository implements Repository<Room> {

    private static RoomRepository roomRepository = null;
    private Set<Room> rooms;

    public RoomRepository(){
        rooms = new HashSet<>();
    }

    public static RoomRepository getRoomRepository() {
        if(roomRepository == null){
            return new RoomRepository();
        }
        return roomRepository;
    }

    @Override
    public Room find(int id) {
        return rooms.stream().filter(room -> room.getRoomId() == id).findAny().orElse(null);
    }

    @Override
    public void create(Room room) {

        rooms.add(room);

    }

    @Override
    public Room read(int id) {
        return find(id);
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
    public void delete(Room room) {

        rooms.remove(room);

    }

    @Override
    public Set<Room> getAll() {
        return rooms;
    }



}
