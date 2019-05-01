package me.mohammedriaz.controllers;

import me.mohammedriaz.domain.employee.Doctor;
import me.mohammedriaz.factories.employee.DoctorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import me.mohammedriaz.services.Impl.DoctorServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorServiceImpl doctorService;

    @Autowired
    public DoctorController(DoctorServiceImpl doctorService) {
        this.doctorService = doctorService;
    }

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
