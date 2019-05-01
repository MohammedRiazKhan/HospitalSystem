package me.mohammedriaz.controllers;

import me.mohammedriaz.domain.visits.Visit;
import me.mohammedriaz.services.Impl.VisitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/visit")
public class VisitController {

    private final VisitServiceImpl visitService;

    @Autowired
    public VisitController(VisitServiceImpl visitService) {
        this.visitService = visitService;
    }

    @PostMapping
    public Visit create(@RequestBody Visit t){
        return visitService.create(t);
    }

    @GetMapping(path = "/find/{id}")
    public Visit findById(@PathVariable int id){
        return visitService.read(id);
    }

    @PutMapping("/update")
    public Visit update(@RequestBody Visit t){
        return visitService.update(t);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable int id){

        visitService.delete(id);

    }

    @GetMapping("/getAll")
    public Set<Visit> getAll(){
        return visitService.getAll();
    }

}
