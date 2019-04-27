package services.Impl;

import domain.hospital.Room;
import repositories.Impl.RoomRepositoryImpl;
import repositories.hospital.RoomRepository;
import services.hospital.RoomService;

import java.util.Set;

public class RoomServiceImpl implements RoomService {


    private RoomServiceImpl service = null;
    private RoomRepository repository;

    public RoomServiceImpl() {
        repository = RoomRepositoryImpl.getRoomRepository();
    }

    public RoomServiceImpl getService(){

        if(service == null){
            return new RoomServiceImpl();
        }
        return service;
    }


    @Override
    public Set<Room> getAll() {
        return repository.getAll();
    }

    @Override
    public Room create(Room room) {
        return repository.create(room);
    }

    @Override
    public Room read(Integer integer) {
        return repository.read(integer);
    }

    @Override
    public Room update(Room room) {
        return repository.update(room);
    }

    @Override
    public void delete(Integer integer) {

        repository.delete(integer);
    }
}
