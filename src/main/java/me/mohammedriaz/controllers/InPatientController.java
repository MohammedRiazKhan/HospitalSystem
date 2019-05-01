package me.mohammedriaz.controllers;

import me.mohammedriaz.domain.patients.InPatient;
import me.mohammedriaz.services.Impl.InPatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("patient/inpatient")
public class InPatientController {

    private final InPatientServiceImpl inPatientService;

    @Autowired
    public InPatientController(InPatientServiceImpl inPatientService) {
        this.inPatientService = inPatientService;
    }


    @PostMapping
    public InPatient create(@RequestBody InPatient t){
        return t;
    }

    @GetMapping(path = "/find/{id}")
    public InPatient findById(@PathVariable int id){
        return null;
    }

    @PutMapping("/update")
    public InPatient update(@RequestBody InPatient t){
        return null;
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable int id){


    }

    @GetMapping("/getAll")
    public Set<InPatient> getAll(){
        return null;
    }

}
