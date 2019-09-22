package me.mohammedriazkhan.controller.hospital;

import me.mohammedriazkhan.domain.hospital.Equipment;
import me.mohammedriazkhan.service.hospital.EquipmentService;
import me.mohammedriazkhan.service.hospital.impl.EquipmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/equipment")
public class EqupmentController {

    @Autowired
    private EquipmentService equipmentService;

    @PostMapping("/new")
    public Equipment create(@RequestBody Equipment equipment){

        return equipmentService.create(equipment);

    }

    @GetMapping("/find/{id}")
    public Equipment read(@PathVariable String id){

        return equipmentService.read(id);

    }

    @PutMapping("/update/")
    public Equipment update(@RequestBody Equipment equipment){

        return equipmentService.update(equipment);

    }

    @DeleteMapping("/delete/{id}")
    public void delete(String id){

        equipmentService.delete(id);

    }

    @GetMapping("/getall")
    public Set<Equipment> getAll(){

        return equipmentService.getAll();

    }


}
