package me.mohammedriazkhan.controller.employee;

import me.mohammedriazkhan.domain.employee.Porter;
import me.mohammedriazkhan.service.employee.impl.PorterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/porter")
public class PorterController {

    @Autowired
    private PorterServiceImpl porterService;

    @PostMapping
    public Porter create(@RequestBody Porter t){
        return porterService.create(t);
    }

    @GetMapping(path = "/find/{id}")
    public Porter findById(@PathVariable String id){
        return porterService.read(id);
    }

    @PutMapping("/update")
    public Porter update(@RequestBody Porter t){
        return porterService.update(t);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        porterService.delete(id);

    }

    @GetMapping("/getAll")
    public Set<Porter> getAll(){
        return porterService.getAll();
    }

}
