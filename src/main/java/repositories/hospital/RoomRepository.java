package repositories.hospital;

import domain.hospital.Room;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public interface RoomRepository extends Repository<Room, Integer> {


    Set<Room> getAll();


}
