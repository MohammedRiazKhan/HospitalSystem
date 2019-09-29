package me.mohammedriazkhan.controller.patient;

import me.mohammedriazkhan.domain.patient.InPatient;
import me.mohammedriazkhan.domain.patient.Patient;
import me.mohammedriazkhan.service.patient.impl.InPatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {

    @Autowired
    private InPatientServiceImpl inPatientService;

    @PostMapping("/new")
    public Patient create(@RequestBody Patient t){
        return inPatientService.create(t);
    }

    @GetMapping(path = "/find/{id}")
    public Patient findById(@PathVariable String id){
        return inPatientService.read(id);
    }

    @PutMapping("/update")
    public Patient update(@RequestBody Patient t){
        return inPatientService.update(t);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){

        inPatientService.delete(id);

    }
    @GetMapping("/getall")
    public Set<Patient> getAll(){
        return inPatientService.getAll();
    }


}
