package me.mohammedriazkhan.controller.hospital;

import me.mohammedriazkhan.domain.hospital.Ward;
import me.mohammedriazkhan.service.hospital.impl.WardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/department/ward")
public class WardController {

    @Autowired
    private WardServiceImpl wardService;

    @PostMapping
    public Ward create(@RequestBody Ward t){
        return wardService.create(t);
    }

    @GetMapping(path = "/find/{id}")
    public Ward findById(@PathVariable String id){
        return wardService.read(id);
    }

    @PutMapping("/update")
    public Ward update(@RequestBody Ward t){
        return wardService.update(t);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        wardService.delete(id);

    }

    @GetMapping("/getAll")
    public Set<Ward> getAll(){
        return wardService.getAll();
    }

}
