package me.mohammedriaz.controllers;

import me.mohammedriaz.domain.employee.Nurse;
import me.mohammedriaz.services.Impl.NurseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/employee/nurse")
public class NurseController {

    private final NurseServiceImpl nurseService;

    @Autowired
    public NurseController(NurseServiceImpl nurseService) {
        this.nurseService = nurseService;
    }


    @PostMapping
    public Nurse create(@RequestBody Nurse t){
        return nurseService.create(t);
    }

    @GetMapping(path = "/find/{id}")
    public Nurse findById(@PathVariable int id){
        return nurseService.read(id);
    }

    @PutMapping("/update")
    public Nurse update(@RequestBody Nurse t){
        return nurseService.update(t);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable int id){

        nurseService.delete(id);

    }

    @GetMapping("/getAll")
    public Set<Nurse> getAll(){
        return nurseService.getAll();
    }

}
