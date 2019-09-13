package me.mohammedriazkhan.service.hospital.impl;

import me.mohammedriazkhan.domain.hospital.Room;
import me.mohammedriazkhan.repository.hospital.impl.RoomRepositoryImpl;
import me.mohammedriazkhan.repository.hospital.RoomRepository;
import me.mohammedriazkhan.service.hospital.RoomService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
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
    public Room read(String integer) {
        return repository.read(integer);
    }

    @Override
    public Room update(Room room) {
        return repository.update(room);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }
}
