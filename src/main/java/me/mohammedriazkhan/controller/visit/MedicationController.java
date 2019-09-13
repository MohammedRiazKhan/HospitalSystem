package me.mohammedriazkhan.controller.visit;

import me.mohammedriazkhan.domain.visit.Medication;
import me.mohammedriazkhan.service.visit.impl.MedicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/medication")
public class MedicationController {


    @Autowired
    private MedicationServiceImpl medicationService;

    @PostMapping
    public Medication create(@RequestBody Medication t){
        return medicationService.create(t);
    }

    @GetMapping(path = "/find/{id}")
    public Medication findById(@PathVariable String id){
        return medicationService.read(id);
    }

    @PutMapping("/update")
    public Medication update(@RequestBody Medication t){
        return medicationService.update(t);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){

        medicationService.delete(id);
    }

    @GetMapping("/getAll")
    public Set<Medication> getAll(){
        return medicationService.getAll();
    }

}
