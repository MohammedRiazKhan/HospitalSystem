package me.mohammedriazkhan.controller.visit;

import me.mohammedriazkhan.domain.visit.Visit;
import me.mohammedriazkhan.service.visit.impl.VisitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/visit")
public class VisitController {

    @Autowired
    private VisitServiceImpl visitService;

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
