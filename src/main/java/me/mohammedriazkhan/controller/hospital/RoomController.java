package me.mohammedriazkhan.controller.hospital;

import me.mohammedriazkhan.domain.hospital.Room;
import me.mohammedriazkhan.service.hospital.impl.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/hospital/room")
public class RoomController {

    @Autowired
    private RoomServiceImpl roomService;


    @PostMapping
    public Room create(@RequestBody Room t){
        return roomService.create(t);
    }

    @GetMapping(path = "/find/{id}")
    public Room findById(@PathVariable String id){
        return roomService.read(id);
    }

    @PutMapping("/update")
    public Room update(@RequestBody Room t){
        return roomService.update(t);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        roomService.delete(id);

    }

    @GetMapping("/getAll")
    public Set<Room> getAll(){
        return roomService.getAll();
    }

}
