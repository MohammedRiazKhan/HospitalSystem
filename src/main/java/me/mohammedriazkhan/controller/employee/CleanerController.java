package me.mohammedriazkhan.controller.employee;

import me.mohammedriazkhan.domain.employee.Cleaner;
import me.mohammedriazkhan.factory.employee.CleanerFactory;
import me.mohammedriazkhan.service.employee.impl.CleanerServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/cleaner")
public class CleanerController {

    @Autowired
    @Qualifier("CleanerServiceImpl")
    private CleanerServiceImpl service;

    @PostMapping("/new")
    public Cleaner create(@RequestBody Cleaner clean){

        return service.create(clean);
    }

    @GetMapping(path = "/find/{id}")
    public Cleaner findById(@PathVariable String id){

        Cleaner cleaner = service.read(id);

        return cleaner;
    }

    @PutMapping("/update")
    public void update(@RequestBody Cleaner cleaner){

        service.update(cleaner);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/getAll")
    public Set<Cleaner> getAll(){
        return service.getAll();
    }

}
