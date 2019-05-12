package me.mohammedriazkhan.controllers;

import me.mohammedriazkhan.domain.hospital.Room;
import me.mohammedriazkhan.services.Impl.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/hospital/room")
public class RoomController {

    private final RoomServiceImpl roomService;

    @Autowired
    public RoomController(RoomServiceImpl roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public Room create(@RequestBody Room t){
        return roomService.create(t);
    }

    @GetMapping(path = "/find/{id}")
    public Room findById(@PathVariable int id){
        return roomService.read(id);
    }

    @PutMapping("/update")
    public Room update(@RequestBody Room t){
        return roomService.update(t);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable int id){
        roomService.delete(id);

    }

    @GetMapping("/getAll")
    public Set<Room> getAll(){
        return roomService.getAll();
    }

}
