package me.mohammedriazkhan.controller.visit;

import me.mohammedriazkhan.domain.visit.MedicalTool;
import me.mohammedriazkhan.service.visit.impl.MedicalToolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/medicaltool")

public class MedicalToolController {

    @Autowired
    private MedicalToolServiceImpl medicalToolService;

    @PostMapping
    public MedicalTool create(@RequestBody MedicalTool t){
        return medicalToolService.create(t);
    }

    @GetMapping(path = "/find/{id}")
    public MedicalTool findById(@PathVariable String id){
        return medicalToolService.read(id);
    }

    @PutMapping("/update")
    public MedicalTool update(@RequestBody MedicalTool t){
        return medicalToolService.update(t);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        medicalToolService.delete(id);

    }

    @GetMapping("/getAll")
    public Set<MedicalTool> getAll(){
        return medicalToolService.getAll();
    }

}
