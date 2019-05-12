package me.mohammedriazkhan.controllers;

import me.mohammedriazkhan.domain.visits.Medication;
import me.mohammedriazkhan.services.Impl.MedicationServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/medication")
public class MedicationController {

    private final MedicationServiceImpl medicationService;

    public MedicationController(MedicationServiceImpl medicationService) {
        this.medicationService = medicationService;
    }


    @PostMapping
    public Medication create(@RequestBody Medication t){
        return medicationService.create(t);
    }

    @GetMapping(path = "/find/{id}")
    public Medication findById(@PathVariable int id){
        return medicationService.read(id);
    }

    @PutMapping("/update")
    public Medication update(@RequestBody Medication t){
        return medicationService.update(t);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable int id){

        medicationService.delete(id);
    }

    @GetMapping("/getAll")
    public Set<Medication> getAll(){
        return medicationService.getAll();
    }

}
