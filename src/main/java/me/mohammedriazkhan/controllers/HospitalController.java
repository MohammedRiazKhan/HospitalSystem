package me.mohammedriazkhan.controllers;

import me.mohammedriazkhan.domain.hospital.Hospital;
import me.mohammedriazkhan.services.Impl.HospitalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    private final HospitalServiceImpl hospitalService;

    @Autowired
    public HospitalController(HospitalServiceImpl hospitalService) {
        this.hospitalService = hospitalService;
    }

    @PostMapping
    public Hospital create(@RequestBody Hospital t){
        return hospitalService.create(t);
    }

    @GetMapping(path = "/find/{id}")
    public Hospital findById(@PathVariable int id){
        return hospitalService.read(id);
    }

    @PutMapping("/update")
    public Hospital update(@RequestBody Hospital t){
        return hospitalService.update(t);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable int id){


        hospitalService.delete(id);
    }

    @GetMapping("/getAll")
    public Set<Hospital> getAll(){
        return hospitalService.getAll();
    }

}
