package me.mohammedriazkhan.controller.employee;

import me.mohammedriazkhan.domain.employee.Pharmacist;
import me.mohammedriazkhan.service.employee.impl.PharmacistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/employee/pharmacist")
public class PharmacistController {

    @Autowired
    private PharmacistServiceImpl pharmacistService;

    @PostMapping
    public Pharmacist create(@RequestBody Pharmacist t){
        return pharmacistService.create(t);
    }

    @GetMapping(path = "/find/{id}")
    public Pharmacist findById(@PathVariable String id){
        return pharmacistService.read(id);
    }

    @PutMapping("/update")
    public Pharmacist update(@RequestBody Pharmacist t){
        return pharmacistService.update(t);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){

        pharmacistService.delete(id);

    }

    @GetMapping("/getAll")
    public Set<Pharmacist> getAll(){
        return pharmacistService.getAll();
    }

}
