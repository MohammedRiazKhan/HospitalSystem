package me.mohammedriazkhan.controller.employee;

import me.mohammedriazkhan.domain.employee.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import me.mohammedriazkhan.service.employee.impl.DoctorServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorServiceImpl doctorService;

    @PostMapping("/new")
    public Doctor create(@RequestBody Doctor doc){

        return doctorService.create(doc);
    }

    @GetMapping(path = "/find/{id}")
    public Doctor findById(@PathVariable int id){

        Doctor doctor = doctorService.read(id);

        return doctor;
    }

    @PutMapping("/update")
    public void update(@RequestBody Doctor doc){

        doctorService.update(doc);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable int id){
        doctorService.delete(id);
    }

    @GetMapping("/getAll")
    public Set<Doctor> getAll(){
        return doctorService.getAll();
    }


}
