package me.mohammedriazkhan.controller.employee;

import me.mohammedriazkhan.domain.employee.Nurse;
import me.mohammedriazkhan.service.employee.impl.NurseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/employee/nurse")
public class NurseController {



    @Autowired
    private NurseServiceImpl nurseService;

    @PostMapping
    public Nurse create(@RequestBody Nurse t){
        return nurseService.create(t);
    }

    @GetMapping(path = "/find/{id}")
    public Nurse findById(@PathVariable String id){
        return nurseService.read(id);
    }

    @PutMapping("/update")
    public Nurse update(@RequestBody Nurse t){
        return nurseService.update(t);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){

        nurseService.delete(id);

    }

    @GetMapping("/getAll")
    public Set<Nurse> getAll(){
        return nurseService.getAll();
    }

}
