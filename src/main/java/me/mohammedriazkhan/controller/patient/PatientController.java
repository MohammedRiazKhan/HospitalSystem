package me.mohammedriazkhan.controller.patient;

import me.mohammedriazkhan.domain.patient.InPatient;
import me.mohammedriazkhan.domain.patient.Patient;
import me.mohammedriazkhan.service.patient.impl.InPatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@RestController

public class PatientController {

    @Autowired
    private InPatientServiceImpl inPatientService;

    @PostMapping("/new")
    public InPatient create(@RequestBody InPatient t) {

        return inPatientService.create(t);
    }

    @GetMapping(path = "/find/{id}")
    public InPatient findById(@PathVariable String id){
        return (InPatient) inPatientService.read(id);
    }

    @PutMapping("/update")
    public InPatient update(@RequestBody InPatient t){
        return inPatientService.update(t);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){

        inPatientService.delete(id);

    }
    @GetMapping("/getall")
    public Set<InPatient> getAll(){
        return inPatientService.getAll();
    }


}
