package me.mohammedriazkhan.controllers;

import me.mohammedriazkhan.domain.visits.MedicalTool;
import me.mohammedriazkhan.services.Impl.MedicalToolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/medicaltool")

public class MedicalToolController {

    private final MedicalToolServiceImpl medicalToolService;

    @Autowired
    public MedicalToolController(MedicalToolServiceImpl medicalToolService) {
        this.medicalToolService = medicalToolService;
    }

    @PostMapping
    public MedicalTool create(@RequestBody MedicalTool t){
        return medicalToolService.create(t);
    }

    @GetMapping(path = "/find/{id}")
    public MedicalTool findById(@PathVariable int id){
        return medicalToolService.read(id);
    }

    @PutMapping("/update")
    public MedicalTool update(@RequestBody MedicalTool t){
        return medicalToolService.update(t);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable int id){
        medicalToolService.delete(id);

    }

    @GetMapping("/getAll")
    public Set<MedicalTool> getAll(){
        return medicalToolService.getAll();
    }

}
