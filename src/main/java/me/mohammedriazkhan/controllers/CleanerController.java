package me.mohammedriazkhan.controllers;

import me.mohammedriazkhan.domain.employee.Cleaner;
import me.mohammedriazkhan.factories.employee.CleanerFactory;
import me.mohammedriazkhan.services.Impl.CleanerServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/cleaner")
public class CleanerController {

    private final CleanerServiceImpl service;

    @Autowired
    public CleanerController(CleanerServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/new")
    public Cleaner create(@RequestBody Cleaner clean){

        Cleaner cleaner = CleanerFactory.getCleaner();

        return service.create(cleaner);
    }

    @GetMapping(path = "/find/{id}")
    public Cleaner findById(@PathVariable int id){

        Cleaner cleaner = service.read(id);

        return cleaner;
    }

    @PutMapping("/update")
    public void update(@RequestBody Cleaner cleaner){

        service.update(cleaner);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }

    @GetMapping("/getAll")
    public Set<Cleaner> getAll(){
        return service.getAll();
    }

}
