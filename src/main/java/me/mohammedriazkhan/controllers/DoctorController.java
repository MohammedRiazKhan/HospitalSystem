package me.mohammedriazkhan.controllers;

import me.mohammedriazkhan.domain.employee.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import me.mohammedriazkhan.services.Impl.DoctorServiceImpl;

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
